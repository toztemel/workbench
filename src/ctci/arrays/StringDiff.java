package ctci.arrays;

class StringDiff {

    boolean oneAway(char[] str1, char[] str2) {
        if (Math.abs(str1.length - str2.length) > 1) {
            return false;
        }

        int index1 = 0;
        int index2 = 0;
        int diff = 0;
        while (index1 < str1.length && index2 < str2.length) {
            if (str1[index1] == str2[index2]) {
                index1++;
                index2++;
            } else if (str1[index1 + 1] == str2[index2]) {
                diff++;
                index1++;
            } else if (str1[index1] == str2[index2 + 1]) {
                diff++;
                index2++;
            } else if (str1[index1 + 1] == str2[index2 + 1]) {
                diff++;
                index1++;
                index2++;
            } else {
                return false;
            }
        }
        return diff < 2;
    }

}
