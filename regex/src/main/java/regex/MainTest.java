package regex;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainTest {

    /**
     * The username consists of  to  characters inclusive. If the username consists of less than  or greater than  characters, then it is an invalid username.
     * The username can only contain alphanumeric characters and underscores (_). Alphanumeric characters describe the character set consisting of lowercase characters , uppercase characters , and digits .
     * The first character of the username must be an alphabetic character, i.e., either lowercase character  or uppercase character .
     */
    @Test
    public void validateUsername() {
//        String regex = "[a-zA-Z][a-zA-Z0-9_]{7,29}";
        String regex = "[a-zA-Z](\\w){7,29}";

        assertTrue("tayfunaoa".matches(regex));
        assertTrue("Tayfunaoa".matches(regex));
        assertFalse("0Tayfunao".matches(regex));
        assertFalse("Julia".matches(regex));
        assertTrue("Samantha".matches(regex));
        assertTrue("Samantha_21".matches(regex));
        assertFalse("1Samantha".matches(regex));
        assertFalse("Samantha?10_2A".matches(regex));
        assertTrue("JuliaZ007".matches(regex));
        assertFalse("Julia@007".matches(regex));
        assertFalse("_Julia007".matches(regex));
    }
}