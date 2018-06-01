package beeper;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    private static AudioStream think;
    private static AudioStream speak;
    private static AudioStream end;

    public static void main(String[] args) throws InterruptedException {
        int timeToThink = 0;
        int timeToSpeak = Integer.parseInt(args[0]);
        if (args.length >= 2 ) {
            timeToThink = timeToSpeak;
            timeToSpeak = Integer.parseInt(args[1]);
        }
        int repeat = 1;
        if (args.length ==3 ) {
            repeat = Integer.parseInt(args[2]);
        }

        for (int i = 0; i < repeat; i++) {
            run(timeToThink, timeToSpeak);
            Thread.sleep(3000);
        }

    }

    private static void run(int timeToThink, int timeToSpeak) {
        try {
            speak = new AudioStream(new FileInputStream(new File("think.wav")));
            think = new AudioStream(new FileInputStream(new File("speak.wav")));
            end = new AudioStream(new FileInputStream(new File("end.wav")));

            phase(think, 0, "START");
            if (timeToThink != 0) {
                phase(speak, timeToThink, "SPEAK");
            }
            phase(end, timeToSpeak, "END");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void phase(AudioStream file, int wait, String prompt) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException {
        drawProgress(wait);
        prompt(prompt);
        beep(file);
    }

    private static void prompt(String prompt) {
        System.out.println("\n==  " + prompt + "  ==\n");
    }

    private static void drawProgress(int wait) throws InterruptedException {
        Thread p = new Thread(() -> {
            try {
                if (wait <= 0){
                    return;
                }
                for (double progress = 0.0; progress <= 1.0; progress += (1.0 / wait)) {
                    updateProgress(progress);
                    if (progress < 1.0) {
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {}
        });
        p.start();
        p.join();

    }

    private static void beep(AudioStream as) throws IOException, InterruptedException {
        AudioPlayer.player.start(as);
    }

    static void updateProgress(double progressPercentage) {
        final int width = 50; // progress bar width in chars
        System.out.println();
        System.out.print("\r[");
        int i = 1;
        for (; i <= (int)(progressPercentage*width); i++) {
            System.out.print("=");
        }
        for (; i < width; i++) {
            System.out.print(" ");
        }
        System.out.println("]");
    }

}
