package ctci.trees;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListOfDepthsTest {

    private ListOfDepths listOfDepths;

    @Before
    public void setUp() throws Exception {
        listOfDepths = new ListOfDepths();
    }

    @Test
    public void depth_of_single_node() throws Exception {
        BinaryTreeNode node = new BinaryTreeNode(10);
        List<List<BinaryTreeNode>> lists = listOfDepths.listOfDepths(node);

        assertEquals(1, lists.size());
        assertEquals(node, lists.get(0).get(0));
    }

    @Test
    public void depth_of_two_nodes() throws Exception {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.addLeft(new BinaryTreeNode(9));
        List<List<BinaryTreeNode>> lists = listOfDepths.listOfDepths(node);

        assertEquals(2, lists.size());
    }

    @Test
    public void depth_of_three_nodes() throws Exception {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.addLeft(new BinaryTreeNode(9));
        node.addRight(new BinaryTreeNode(11));
        List<List<BinaryTreeNode>> lists = listOfDepths.listOfDepths(node);

        assertEquals(2, lists.size());
    }

    @Test
    public void depth_of_four_nodes() throws Exception {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.addLeft(new BinaryTreeNode(9));
        node.addRight(new BinaryTreeNode(11));
        node.right.addRight(new BinaryTreeNode(12));
        List<List<BinaryTreeNode>> lists = listOfDepths.listOfDepths(node);

        assertEquals(3, lists.size());
    }

    @Test
    public void depth_of_five_nodes() throws Exception {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.addLeft(new BinaryTreeNode(8));
        node.left.addLeft(new BinaryTreeNode(9));
        node.addRight(new BinaryTreeNode(11));
        node.right.addRight(new BinaryTreeNode(12));
        List<List<BinaryTreeNode>> lists = listOfDepths.listOfDepths(node);

        assertEquals(3, lists.size());
    }

    @Test
    public void depth_of_seven_nodes() throws Exception {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.addLeft(new BinaryTreeNode(2));
        node.left.addLeft(new BinaryTreeNode(1));
        node.left.addRight(new BinaryTreeNode(3));
        node.addRight(new BinaryTreeNode(12));
        node.right.addLeft(new BinaryTreeNode(11));
        node.right.addRight(new BinaryTreeNode(13));
        List<List<BinaryTreeNode>> lists = listOfDepths.listOfDepths(node);

        assertEquals(3, lists.size());
    }

    @Test
    public void depth_of_eight_nodes() throws Exception {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.addLeft(new BinaryTreeNode(2));
        node.left.addLeft(new BinaryTreeNode(1));
        node.left.addRight(new BinaryTreeNode(3));
        node.addRight(new BinaryTreeNode(12));
        node.right.addLeft(new BinaryTreeNode(11));
        node.right.addRight(new BinaryTreeNode(13));
        node.right.right.addLeft(new BinaryTreeNode(15));

        List<List<BinaryTreeNode>> lists = listOfDepths.listOfDepths(node);

        assertEquals(4, lists.size());
    }

}