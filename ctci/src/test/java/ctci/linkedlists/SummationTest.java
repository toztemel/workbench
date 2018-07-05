package ctci.linkedlists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SummationTest {

    Summation summation;

    Node node1;
    Node node2;

    Node node1Reverse;
    Node node2Reverse;


    @Before
    public void setUp() {
        node1 = Node.createList(7, 1, 6);
        node2 = Node.createList(5, 9, 2);
        node1Reverse = Node.createList(6, 1, 7);
        node2Reverse = Node.createList(2, 9, 5);

        summation = new Summation();
    }

    @Test
    public void each_node_contains_a_digit() {
        assertEquals(617, node1.toInt());
        assertEquals(295, node2.toInt());
        assertEquals(716, node1Reverse.toInt());
        assertEquals(592, node2Reverse.toInt());
    }

    @Test
    public void list_can_be_created_from_an_int() {
        assertEquals(617, Node.from(617).toInt());
        assertEquals(295, Node.from(295).toInt());
        assertEquals(716, Node.from(716).toInt());
        assertEquals(592, Node.from(592).toInt());
    }

    @Test
    public void adds_two_numbers_returns_the_sum() {
        Node result = summation.sum(node1, node2);
        Node expected = Node.createList(2, 1, 9);

        assertEquals(expected.toInt(), result.toInt());

        result = summation.sum(node1Reverse, node2Reverse);
        Node expected2 = Node.createList(8, 0, 3, 1);
        assertEquals(expected2.toInt(), result.toInt());


    }

}