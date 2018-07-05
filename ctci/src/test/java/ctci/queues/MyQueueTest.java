package ctci.queues;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyQueueTest {
    @Test
    public void queue_is_a_fifo_structure() throws Exception {
        MyQueue<Integer> q = new MyQueue<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        assertEquals(1, q.peek().intValue());
        assertEquals(1, q.remove().intValue());

        assertEquals(2, q.peek().intValue());
        assertEquals(2, q.remove().intValue());

        assertEquals(3, q.peek().intValue());
        assertEquals(3, q.remove().intValue());

        assertEquals(4, q.peek().intValue());
        assertEquals(4, q.remove().intValue());

        assertTrue(q.isEmpty());
    }

}