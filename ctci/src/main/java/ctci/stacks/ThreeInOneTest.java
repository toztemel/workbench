package ctci.stacks;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.stream.IntStream;

import static ctci.stacks.ThreeInOne.StackIndex.*;
import static org.junit.Assert.*;

public class ThreeInOneTest {

    ThreeInOne stack;

    @Before
    public void setUp() {
        stack = new ThreeInOne(5);
    }

    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty(A));
        assertTrue(stack.isEmpty(B));
        assertTrue(stack.isEmpty(C));

        try {
            stack.push(A, 1);
            stack.pop(A);
            assertTrue(stack.isEmpty(A));
        } catch (ThreeInOne.FullStackException e) {
            fail();
        }
    }

    @Test(expected = ThreeInOne.FullStackException.class)
    public void push_throws_exception_when_full() {
        stack.push(A, 1);
        stack.push(A, 2);
        stack.push(A, 3);
        stack.push(A, 4);
        stack.push(A, 5);
        stack.push(A, 6);
    }

    @Test(expected = EmptyStackException.class)
    public void pop_throws_exception_when_empty() {
        stack.pop(A);
    }

    @Test(expected = EmptyStackException.class)
    public void pop_throws_exception_when_emptied() {
        stack.push(A, 1);
        stack.pop(A);
        stack.pop(A);
    }

    @Test
    public void push_to_full() {
        IntStream.range(1, 6)
                .forEach(i -> {
                    stack.push(A, i);
                    stack.push(B, i + 10);
                    stack.push(C, i + 20);
                });

        IntStream.range(1, 6)
                .forEach(i -> {
                    assertEquals(6-i, stack.pop(A));
                    assertEquals(6-i + 10, stack.pop(B));
                    assertEquals(6-i + 20, stack.pop(C));
                });
        assertTrue(stack.isEmpty(A));
        assertTrue(stack.isEmpty(B));
        assertTrue(stack.isEmpty(C));

    }
}