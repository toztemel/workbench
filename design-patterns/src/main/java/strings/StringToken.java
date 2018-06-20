package strings;

import java.util.Scanner;

/**
 * Created by tayfuno on 06/04/16.
 */
public class StringToken {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        //Complete the code

        String regex = "[ !,?._'@]+";
        String[] output = s.split(regex);
        System.out.println(output.length);
        for (int i = 0; i < output.length; i++)
            System.out.println(output[i]);
    }


}
