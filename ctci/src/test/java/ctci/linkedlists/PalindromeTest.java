package ctci.linkedlists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeTest {

    private Palindrome p;

    @Before
    public void setup() {
        p = new Palindrome();
    }

    @Test
    public void checks_is_palindrome() throws Exception {
        assertTrue(p.isPalindrome(Node.from(1)));
        assertTrue(p.isPalindrome(Node.from(11)));
        assertTrue(p.isPalindrome(Node.from(121)));
        assertTrue(p.isPalindrome(Node.from(1221)));
        assertTrue(p.isPalindrome(Node.from(12321)));
        assertTrue(p.isPalindrome(Node.from(123454321)));
    }

    @Test
    public void checks_is_NOT_palindrome() throws Exception {
        assertFalse(p.isPalindrome(Node.from(12)));
        assertFalse(p.isPalindrome(Node.from(112)));
        assertFalse(p.isPalindrome(Node.from(122)));
        assertFalse(p.isPalindrome(Node.from(1212)));
        assertFalse(p.isPalindrome(Node.from(12312)));
        assertFalse(p.isPalindrome(Node.from(12345)));
    }
    
    @Test
    public void checks_is_palindrome2() throws Exception {
        assertTrue(p.isPalindrome2(Node.from(1)));
        assertTrue(p.isPalindrome2(Node.from(11)));
        assertTrue(p.isPalindrome2(Node.from(121)));
        assertTrue(p.isPalindrome2(Node.from(1221)));
        assertTrue(p.isPalindrome2(Node.from(12321)));
        assertTrue(p.isPalindrome2(Node.from(123454321)));
    }

    @Test
    public void checks_is_NOT_palindrome2() throws Exception {
        assertFalse(p.isPalindrome2(Node.from(12)));
        assertFalse(p.isPalindrome2(Node.from(112)));
        assertFalse(p.isPalindrome2(Node.from(122)));
        assertFalse(p.isPalindrome2(Node.from(1212)));
        assertFalse(p.isPalindrome2(Node.from(12312)));
        assertFalse(p.isPalindrome2(Node.from(12345)));
    }

}