package ctci.arrays;

class UniqueCharChecker {

    boolean containsUniqueChars(String str) {
        int uniqueCharBits = 0;
        for (int i = 0; i < str.length(); i++) {
            int charIndex = str.charAt(i) - 'a';
            int charBit = 1 << charIndex;
            if ((uniqueCharBits & charBit) > 0) {
                return false;
            }
            uniqueCharBits |= charBit;
        }
        return true;
    }

    boolean containsUniqueCharsCaseSensitive(String str) {
        boolean[] chars = new boolean[64];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (chars[c - 'A']) {
                return false;
            }
            chars[c - 'A'] = true;
        }
        return true;
    }

}