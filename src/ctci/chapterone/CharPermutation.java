package ctci.chapterone;

class CharPermutation {

    boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] charCounter = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            charCounter[c]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            charCounter[c]--;

            if (charCounter[c] < 0) {
                return false;
            }
        }
        return true;
    }

    boolean isPalindromePermutation(String str) {
        String input = str.toLowerCase();
        int[] characters = new int[32];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                continue;
            }
            characters[c - 'a']++;
        }
        boolean singleChar = false;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] % 2 == 0) {
                continue;
            } else if (characters[i] == 1) {
                if (singleChar) {
                    return false;
                } else {
                    singleChar = true;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
