package ctci.linkedlists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IntersectionTest {

    private Intersection intersection;
    private Node intersectingNode;
    private Node intersectingNodes;

    @Before
    public void setup() {
        intersection = new Intersection();
        intersectingNode = new Node(5);
        intersectingNodes = Node.createList(5, 6, 7, 8, 9);
    }

    @Test
    public void two_lists_intersects_on_the_same_node() {
        Node list1 = Node.createList(1, 2, 3)
                .appendToTail(intersectingNode)
                .appendToTail(Node.createList(6, 7, 8, 9));

        Node list2 = Node.createList(0, 1, 2, 3, 4)
                .appendToTail(intersectingNode)
                .appendToTail(Node.createList(4, 3, 2, 1));


        Node result = intersection.intersect(list1, list2);

        assertEquals(intersectingNode, result);
    }

    @Test
    public void intersection_is_based_on_reference() {

        Node list1 = Node.createList(1, 2, 3)
                .appendToTail(new Node(5))
                .appendToTail(Node.createList(6, 7, 8, 9));

        Node list2 = Node.createList(0, 1, 2, 3, 4)
                .appendToTail(new Node(5))
                .appendToTail(Node.createList(4, 3, 2, 1));


        Node result = intersection.intersect(list1, list2);

        assertNull(result);
    }

    @Test
    public void two_lists_not_intersects() {
        Node list1 = Node.createList(1, 2, 3)
                .appendToTail(Node.createList(6, 7, 8, 9));

        Node list2 = Node.createList(0, 1, 2, 3, 4)
                .appendToTail(Node.createList(4, 3, 2, 1));


        Node result = intersection.intersect(list1, list2);

        assertNull(result);
    }

    @Test
    public void two_lists_intersects_on_the_some_nodes() {
        Node list1 = Node.createList(1, 2, 3)
                .appendToTail(intersectingNodes);

        Node list2 = Node.createList(4, 3, 2, 1, 2, 3, 4)
                .appendToTail(intersectingNodes);

        Node result = intersection.intersectMulti(list1, list2);

        assertEquals(intersectingNodes, result);
    }

}