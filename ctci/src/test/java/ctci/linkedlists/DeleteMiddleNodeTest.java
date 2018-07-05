package ctci.linkedlists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DeleteMiddleNodeTest {
    @Test
    public void deleteMiddleNode() throws Exception {
        Node list = Node.createList(0, 1, 2, 3, 4, 5);
        DeleteMiddleNode delete = new DeleteMiddleNode();

        delete.deleteMiddleNode(list.next.next);

        assertEquals(0, list.data);

        Node expected = Node.createList(0, 1, 3, 4, 5);
        Node l = list;

        while (expected.next != null) {
            assertEquals(expected.data, l.data);

            expected = expected.next;
            l = l.next;
        }
        assertNull(l.next);
    }

}