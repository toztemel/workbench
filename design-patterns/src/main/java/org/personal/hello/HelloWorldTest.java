package org.personal.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by tayfuno on 07/02/14.
 */
public class HelloWorldTest {
	@Test
    public void testGet() {
        HelloWorld hello = new HelloWorld();
        int i = hello.getI();
        assertEquals(i ,0);
    }
}
