package ctci.linkedlists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LoopDetectionTest {

    private LoopDetection detection;

    @Before
    public void setup() {
        detection = new LoopDetection();
    }

    @Test
    public void detects_non_loop() throws Exception {
        Node noncircularList = Node.createList(1, 2, 3, 4, 3, 2, 1);
        Node result = detection.detectLoop(noncircularList);

        assertNull(result);
    }

    @Test
    public void detectLoop() throws Exception {
        Node loopHead = new Node(5);
        Node circularList = Node.createList(1, 2, 3, 4)
                .appendToTail(loopHead)
                .appendToTail(Node.createList(6, 7, 8, 9))
                .appendToTail(loopHead);

        Node result = detection.detectLoop(circularList);

        assertEquals(loopHead, result);
    }

}