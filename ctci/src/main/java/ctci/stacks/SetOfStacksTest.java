package ctci.stacks;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SetOfStacksTest {

    SetOfStacks stack;

    @Before
    public void setUp() throws Exception {
        stack = new SetOfStacks(3);
    }

    @Test
    public void push() throws Exception {
        IntStream.range(1, 10)
                .forEach(stack::push);

        assertEquals(new Integer(9), stack.peek());

        IntStream.range(1, 10)
                .forEach(i -> {
                    assertEquals(new Integer(10-i), stack.pop());
                });

        assertTrue(stack.isEmpty());
    }

    @Test
    public void popAtIndex() {
        IntStream.range(1, 10)
                .forEach(stack::push);

        assertEquals(Integer.valueOf(3), stack.popAt(0));
        assertEquals(Integer.valueOf(7), stack.popAt(1));
    }

}