package ctci.linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class FinderTest {

    @Test
    public void findLastKthElement() {
        Finder finder = new Finder();
        Node head = Node.createList(1, 2, 3);

        Node n = finder.findLastKthValue(head, 1);
        assertEquals(3, n.data);

        n = finder.findLastKthValue(head, 2);
        assertEquals(2, n.data);
    }
}