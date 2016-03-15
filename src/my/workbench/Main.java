package my.workbench;

import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            String output = parseLine(line);
            System.out.println(output);
            testCases--;
        }
    }

    static String parseLine(String line) {
        String result = "None";

        String tagName = getTagName(line);
        String startTagName = getStartTag(line);
        String endTagName = getEndTag(startTagName);

        if (line.contains(startTagName) && line.contains(endTagName)) {
            System.out.println(line);
        }
        return result;
    }

    static String getTagName(String line) {
        int leftIndex = line.indexOf("<");
        int rightIndex = line.indexOf(">");
        String tagname = line.substring(leftIndex, rightIndex+1);
        return tagname;
    }

    static String getStartTag(String tagName) {
        return "<"+tagName+">";
    }

    static String getEndTag(String tagName) {
        return "</"+tagName+">";
    }

}

