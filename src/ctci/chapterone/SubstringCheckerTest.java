package ctci.chapterone;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubstringCheckerTest {

    @Test
    public void testUniqueChars() {
        UniqueCharChecker checker = new UniqueCharChecker();

        assertTrue(checker.containsUniqueChars("abcdef"));
        assertTrue(checker.containsUniqueChars("acfhijl"));
        assertTrue(checker.containsUniqueChars("pyfgcrlaoeuidhtnsqjkxbmwv"));
    }

    @Test
    public void testNonUniqueChars() {
        UniqueCharChecker checker = new UniqueCharChecker();

        assertFalse(checker.containsUniqueChars("aa"));
        assertFalse(checker.containsUniqueChars("aA"));
        assertFalse(checker.containsUniqueChars("aba"));
        assertFalse(checker.containsUniqueChars("abcdefga"));
        assertFalse(checker.containsUniqueChars("oztemel"));
        assertFalse(checker.containsUniqueChars("zubiz"));
    }

    @Test
    public void testCaseSensitiveUniqueChars() {
        UniqueCharChecker checker = new UniqueCharChecker();

        assertTrue(checker.containsUniqueCharsCaseSensitive("aA"));
        assertTrue(checker.containsUniqueCharsCaseSensitive("abcdABCD"));
    }

    @Test
    public void testMakeURLReplaceAll() throws Exception {
        URLMaker urlify = new URLMaker();

        assertEquals(urlify.replaceAllAndMakeUrl("abcd", 1), "abcd");
        assertEquals(urlify.replaceAllAndMakeUrl(" abcd ", 1), "abcd");
        assertEquals(urlify.replaceAllAndMakeUrl("ab cd", 1), "ab%20cd");
        assertEquals(urlify.replaceAllAndMakeUrl(" ab cd ", 1), "ab%20cd");
    }

    @Test
    public void testMakeURLLoop() {
        URLMaker urlify = new URLMaker();

        char[] input = new char[]{'a', ' ', 'b', ' ', ' '};
        urlify.loopAndMakeURL(input, 3);
        assertEquals("a%20b", new String(input));

        input = new char[]{'a', ' ', ' ', 'b', ' ', ' ', ' ', ' '};
        urlify.loopAndMakeURL(input, 4);
        assertEquals("a%20%20b", new String(input));
    }

    @Test
    public void testPermutatedStrings() {
        CharPermutation checker = new CharPermutation();

        assertTrue(checker.isPermutation("abcd", "abcd"));
        assertTrue(checker.isPermutation("abcd", "dcba"));
        assertTrue(checker.isPermutation("aBCd", "adBC"));
    }

    @Test
    public void testNonPermutatedStrings() {
        CharPermutation checker = new CharPermutation();

        assertFalse(checker.isPermutation("a", "aa"));
        assertFalse(checker.isPermutation("aa", "ab"));
        assertFalse(checker.isPermutation("ab", "aab"));
        assertFalse(checker.isPermutation("abC", "abc"));
        assertFalse(checker.isPermutation("Abcd", "adcb"));
    }

    @Test
    public void testPalindromePermutation() {
        CharPermutation checker = new CharPermutation();

        assertTrue(checker.isPalindromePermutation("a"));
        assertTrue(checker.isPalindromePermutation("aa"));
        assertTrue(checker.isPalindromePermutation("aba"));
        assertTrue(checker.isPalindromePermutation("abba"));
        assertTrue(checker.isPalindromePermutation("aabb"));
        assertTrue(checker.isPalindromePermutation("abab"));
        assertTrue(checker.isPalindromePermutation("abcba"));
        assertTrue(checker.isPalindromePermutation("abcab"));
        assertTrue(checker.isPalindromePermutation("Tact Coa"));
        assertTrue(checker.isPalindromePermutation("taco cat"));
        assertTrue(checker.isPalindromePermutation("atco cta"));

        assertFalse(checker.isPalindromePermutation("ab"));
        assertFalse(checker.isPalindromePermutation("abc"));
        assertFalse(checker.isPalindromePermutation("abac"));

    }

    @Test
    public void testOneAway() {
        StringDiff checker = new StringDiff();

        assertTrue(checker.oneAway("pale".toCharArray(), "ple".toCharArray()));
        assertTrue(checker.oneAway("pales".toCharArray(), "pale".toCharArray()));
        assertTrue(checker.oneAway("pale".toCharArray(), "bale".toCharArray()));

        assertFalse(checker.oneAway("pale".toCharArray(), "bake".toCharArray()));
    }

    @Test
    public void testCompression() {
        StringCompressor checker = new StringCompressor();

        assertEquals("a", checker.compress("a".toCharArray()));
        assertEquals("aa", checker.compress("aa".toCharArray()));
        assertEquals("ab", checker.compress("ab".toCharArray()));
        assertEquals("abb", checker.compress("abb".toCharArray()));
        assertEquals("abc", checker.compress("abc".toCharArray()));
        assertEquals("abcd", checker.compress("abcd".toCharArray()));
        assertEquals("aabcd", checker.compress("aabcd".toCharArray()));
        assertEquals("aaabcd", checker.compress("aaabcd".toCharArray()));
        assertEquals("aaabcd", checker.compress("aaabcd".toCharArray()));
        assertEquals("aaaabcd", checker.compress("aaaabcd".toCharArray()));
        assertEquals("aaaaabcd", checker.compress("aaaaabcd".toCharArray()));

        assertEquals("a6b1c1d1", checker.compress("aaaaaabcd".toCharArray()));
        assertEquals("a2b1c5a3", checker.compress("aabcccccaaa".toCharArray()));
    }

    @Test
    public void testRotateMatrixInPlace() {
        MatrixHandler checker = new MatrixHandler();

        int N = 10;
        int[][] image = new int[][]{
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24}
        };
        checker.rotateMatrixInPlace(image);
        checker.rotateMatrixInPlace(image);
        checker.rotateMatrixInPlace(image);
        checker.rotateMatrixInPlace(image);

        assertEquals(0, image[0][0]);
        assertEquals(1, image[0][1]);
        assertEquals(6, image[1][1]);
        assertEquals(7, image[1][2]);
        assertEquals(12, image[2][2]);
        assertEquals(18, image[3][3]);
        assertEquals(24, image[4][4]);
    }

    @Test
    public void testZeroMatrix() {

        int[][] input = new int[][]{
                {1, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 0, 12, 13, 14},
                {15, 16, 0, 18, 19},
                {20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29},
        };

        int[][] expected = new int[][]{
                {1, 0, 0, 3, 4},
                {5, 0, 0, 8, 9},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {20, 0, 0, 23, 24},
                {25, 0, 0, 28, 29}
        };

        MatrixHandler checker = new MatrixHandler();
        checker.zeroifyMatrix(input);

        assertTrue(equalMatrices(expected, input));

    }

    private boolean equalMatrices(int[][] expected, int[][] input) {
        if(expected.length != input.length) {
            return false;
        }
        if (expected[0].length != input[0].length) {
            return false;
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] != expected[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testStringRotation() {
        SubstringChecker checker = new SubstringChecker();

        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        assertTrue(checker.isRotated(s1, s2));
    }
}