package strings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by tayfuno on 06/04/16.
 */
public class StringTest {

    @Test
    public void testCharAt() {
        assertThat("abcd".charAt(2), is('c'));
        assertThat("abcd".charAt(2), is('c'));
    }

    @Test
    public void testCompareToIgnoreCase() {
        assertThat("abcd".compareToIgnoreCase("AbCd"), is(0));
        assertTrue("abcd".compareToIgnoreCase("AbCde") < 0);
        assertTrue("abcd".compareToIgnoreCase("Abc") > 0);
    }

    @Test
    public void testLength() {
        assertThat("abcd".length(), is(4));
    }

    @Test
    public void testGetChars() {
        assertThat("abcd".toCharArray(), is(new char[]{'a', 'b', 'c', 'd'}));
    }

    @Test
    public void testEquals() {
        assertThat("abcd", is("abcd"));
    }

    @Test
    public void testEqualsIgnoreCase() {
        assertThat("abcd".equalsIgnoreCase("AbCd"), is(true));
    }

    @Test
    public void testIndexOf() {
        assertThat("abcd".indexOf('c'), is(2));
        assertThat("abcd".indexOf('c', 1), is(2));
        assertThat("cbcd".indexOf('c', 0), is(0));
        assertThat("cbcd".indexOf('c', 1), is(2));
    }

    @Test
    public void testsubstring() {
        assertThat("abcd".substring(1, 3), is("bc"));
    }

    @Test
    public void testStaticJoin() {
        assertThat(String.join(" - ", "Java", "is", "cool"), is("Java - is - cool"));
    }

    @Test
    public void testStaticValueOf() {
        assertThat(String.valueOf(new char[]{'a', 'b', 'c', 'd'}), is("abcd"));
    }

    @Test
    public void testToCharArray() {
        assertThat("abcd".toCharArray(), is(new char[]{'a','b','c','d'}));
    }
}
