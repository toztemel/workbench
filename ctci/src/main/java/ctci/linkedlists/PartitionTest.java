package ctci.linkedlists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PartitionTest {

    private Node list;
    private Partition partition;

    @Before
    public void setup() {
        partition = new Partition();
        list = Node.createList(3, 5, 8, 5, 10, 2, 1);
    }

    @Test
    public void partitions_a_list_around_a_value() {
        partition.split(list, 5);

        Node index = list;
        boolean partition2 = false;
        while (index != null) {
            if (index.data < 5) {
                assertFalse(partition2);
            } else {
                partition2 = true;
            }
            index = index.next;
        }
    }

    @Test
    public void smaller_nodes_comes_before_greater_nodes_including_X() {
        final int key = 5;
        partition.split(list, key);


        boolean found = false;
        while (list != null) {
            if (!found && list.data >= key) {
                found = true;
            }

            assertTrue(found ? list.data >= key : list.data < key);

            list = list.next;
        }
    }

}