package ctci.stacks;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThreeInOneTangledTest {

    private ThreeInOneTangled stacks;

    @Before
    public void setUp() throws Exception {
        stacks = new ThreeInOneTangled(15);
    }

    @Test
    public void push_single_item_each() throws Exception {
        stacks.push(1, 100);
        stacks.push(2, 200);
        stacks.push(3, 300);

        assertEquals(100, stacks.peek(1));
        assertEquals(200, stacks.peek(2));
        assertEquals(300, stacks.peek(3));
    }

    @Test
    public void push_to_limit() throws Exception {
        stacks.push(1, 100);
        stacks.push(1, 101);
        stacks.push(1, 102);
        stacks.push(1, 103);
        stacks.push(1, 104);

        assertEquals(104, stacks.peek(1));
        assertEquals(104, stacks.pop(1));
        assertEquals(103, stacks.peek(1));
        assertEquals(103, stacks.pop(1));
        assertEquals(102, stacks.peek(1));
        assertEquals(102, stacks.pop(1));
        assertEquals(101, stacks.peek(1));
        assertEquals(101, stacks.pop(1));
        assertEquals(100, stacks.peek(1));
        assertEquals(100, stacks.pop(1));
        assertTrue(stacks.isEmpty(1));
    }

    @Test(expected = RuntimeException.class)
    public void push_throws_exception_when_full(){
        stacks.push(1, 1);
        stacks.push(1, 1);
        stacks.push(1, 1);
        stacks.push(1, 1);
        stacks.push(1, 1);
        stacks.push(1, 1);
    }

    @Test(expected = EmptyStackException.class)
    public void pop_throws_exception_when_empty(){
        stacks.pop(1);
    }

    @Test(expected = EmptyStackException.class)
    public void pop_throws_exception_when_emptied(){
        stacks.push(1, 1);
        stacks.pop(1);
        stacks.pop(1);
    }

    @Test
    public void pop_multiple_items_each() throws Exception {
        stacks.push(1, 100);
        stacks.push(1, 101);
        stacks.push(1, 102);
        stacks.push(2, 200);
        stacks.push(2, 201);
        stacks.push(2, 202);
        stacks.push(3, 300);
        stacks.push(3, 301);
        stacks.push(3, 302);

        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < 3; j++) {
                int expected = 100 * i + 2 - j;
                assertEquals(expected, stacks.peek(i));
                assertEquals(expected, stacks.pop(i));
            }
        }

        IntStream.range(1, 3).forEach(stacks::isEmpty);
    }

}