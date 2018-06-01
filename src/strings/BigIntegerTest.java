package strings;

import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.Assert.assertEquals;

/**
 * Created by tayfuno on 06/04/16.
 */
public class BigIntegerTest {

    @Test
    public void testSum() {
        BigInteger a = BigInteger.valueOf(11);
        BigInteger b = BigInteger.valueOf(9);

        assertEquals(BigInteger.valueOf(20), a.add(b));
        assertEquals(BigInteger.valueOf(99), a.multiply(b));
    }
}
