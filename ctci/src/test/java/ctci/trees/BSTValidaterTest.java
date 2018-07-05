package ctci.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BSTValidaterTest {

    private BSTValidater bstValidater;

    @Before
    public void setup() {
        bstValidater = new BSTValidater();
    }

    @Test
    public void null_tree_isBST() throws Exception {
        assertTrue(bstValidater.isBST(null));
    }


    @Test
    public void single_node_tree_isBST() throws Exception {
        assertTrue(bstValidater.isBST(new BinaryTreeNode(0)));
    }

    @Test
    public void two_node_tree_isBST() throws Exception {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(3);

        assertTrue(bstValidater.isBST(root));
    }

    @Test
    public void two_node_tree_may_not_be_BST() throws Exception {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.addRight(new BinaryTreeNode(2));

        assertFalse(bstValidater.isBST(root));
    }

    @Test
    public void two_node_tree_may_not_be_BST2() throws Exception {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.addLeft(new BinaryTreeNode(4));

        assertFalse(bstValidater.isBST(root));
    }

    @Test
    public void three_node_tree_isBST2() throws Exception {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.addLeft(new BinaryTreeNode(2));
        root.addRight(new BinaryTreeNode(4));

        assertTrue(bstValidater.isBST(root));
    }

    @Test
    public void seven_node_tree_isBST2() throws Exception {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.addLeft(new BinaryTreeNode(1));
        root.left.addLeft(new BinaryTreeNode(0));
        root.left.addRight(new BinaryTreeNode(2));
        root.addRight(new BinaryTreeNode(5));
        root.right.addLeft(new BinaryTreeNode(4));
        root.right.addRight(new BinaryTreeNode(6));

        assertTrue(bstValidater.isBST(root));
    }


    @Test
    public void seven_node_tree_isNotBST2() throws Exception {
        BinaryTreeNode root = new BinaryTreeNode(4);
        root.addLeft(new BinaryTreeNode(1));
        root.left.addLeft(new BinaryTreeNode(0));
        root.left.addRight(new BinaryTreeNode(2));
        root.addRight(new BinaryTreeNode(5));
        root.right.addLeft(new BinaryTreeNode(3));// cannot be smaller than 4
        root.right.addRight(new BinaryTreeNode(6));

        assertFalse(bstValidater.isBST(root));
    }

}