package ctci.linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteMiddleNodeTest {
    @Test
    public void deleteMiddleNode() throws Exception {
        Node list = Node.createList(0, 1, 2, 3, 4, 5);
        DeleteMiddleNode delete = new DeleteMiddleNode();

        delete.deleteMiddleNode(list.next.next);

        assertEquals(0, list.data);

        assertEquals(0, list.data);
    }

}