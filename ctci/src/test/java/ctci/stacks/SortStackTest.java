package ctci.stacks;

import org.junit.Test;

import java.util.Stack;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SortStackTest {

    @Test
    public void sort() throws Exception {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(10);
        stack.push(2);
        stack.push(9);
        stack.push(3);
        stack.push(8);
        stack.push(4);
        stack.push(7);
        stack.push(5);
        stack.push(6);

        new SortStack().sort(stack);

        IntStream.range(1, 10)
                .forEach(i -> assertEquals(Integer.valueOf(i), stack.pop()));
    }

    @Test
    public void sort2() throws Exception {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(110);
        stack.push(122);
        stack.push(92);
        stack.push(3124);
        stack.push(82);
        stack.push(44);
        stack.push(743);
        stack.push(52);
        stack.push(64);
        stack.push(0);

        new SortStack().sort(stack);

        assertEquals(Integer.valueOf(0), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertEquals(Integer.valueOf(44), stack.pop());
        assertEquals(Integer.valueOf(52), stack.pop());
        assertEquals(Integer.valueOf(64), stack.pop());
        assertEquals(Integer.valueOf(82), stack.pop());
        assertEquals(Integer.valueOf(92), stack.pop());
        assertEquals(Integer.valueOf(110), stack.pop());
        assertEquals(Integer.valueOf(122), stack.pop());
        assertEquals(Integer.valueOf(743), stack.pop());
        assertEquals(Integer.valueOf(3124), stack.pop());
    }

}