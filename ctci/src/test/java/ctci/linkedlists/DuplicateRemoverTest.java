package ctci.linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateRemoverTest {

    @Test
    public void testRemoveDuplicate() {
        DuplicateRemover remover = new DuplicateRemover();

        Node n = Node.createList(new int[]{1, 2});
        remover.deleteDuplicates(n);
        assertEquals("1-2", n.printList());

        n = Node.createList(new int[]{1, 1, 2});
        remover.deleteDuplicates(n);
        assertEquals("1-2", n.printList());

        n = Node.createList(new int[]{1, 2, 1, 2, 3});
        remover.deleteDuplicates(n);
        assertEquals("1-2-3", n.printList());
    }

    @Test
    public void testRemoveDuplicateBufferless() {
        DuplicateRemover remover = new DuplicateRemover();

        Node n = Node.createList(new int[]{1, 2});
        remover.deleteDuplicatesWithoutBuffer(n);
        assertEquals("1-2", n.printList());

        n = Node.createList(new int[] {1,1,2});
        remover.deleteDuplicatesWithoutBuffer(n);
        assertEquals("1-2", n.printList());

        n = Node.createList(new int[] {1, 2, 1, 2, 3});
        remover.deleteDuplicatesWithoutBuffer(n);
        assertEquals("1-2-3", n.printList());

    }


}