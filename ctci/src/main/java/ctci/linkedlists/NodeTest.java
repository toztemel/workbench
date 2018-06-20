package ctci.linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void equals() throws Exception {

        Node n = Node.createList(0, 1, 2);
        Node m = Node.createList(0, 1, 2);
        Node k = Node.createList(0, 1);

        assertTrue(Node.equals(n, m));
        assertFalse(Node.equals(n, k));
    }

}