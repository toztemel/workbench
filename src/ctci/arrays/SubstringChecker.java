package ctci.arrays;

class SubstringChecker {

    boolean isRotated(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        return isSubstring(s2.concat(s2), s1);

    }

    boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

}
