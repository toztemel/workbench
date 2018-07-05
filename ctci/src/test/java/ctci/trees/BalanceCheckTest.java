package ctci.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalanceCheckTest {
    @Test
    public void null_isBalanced() throws Exception {
        BalanceCheck check = new BalanceCheck();

        BalanceCheck.DepthNode node = null;
        assertTrue(check.isBalanced(node));
    }

    @Test
    public void one_node_isBalanced() throws Exception {
        BalanceCheck check = new BalanceCheck();

        BalanceCheck.DepthNode node = new BalanceCheck.DepthNode();
        assertTrue(check.isBalanced(node));
    }

    @Test
    public void two_nodes_tree_isBalanced() throws Exception {
        BalanceCheck check = new BalanceCheck();

        BalanceCheck.DepthNode node = new BalanceCheck.DepthNode();
        node.left = new BalanceCheck.DepthNode();

        assertTrue(check.isBalanced(node));
    }

   @Test
    public void three_nodes_tree_isBalanced() throws Exception {
        BalanceCheck check = new BalanceCheck();

        BalanceCheck.DepthNode node = new BalanceCheck.DepthNode();
        node.left = new BalanceCheck.DepthNode();
        node.right = new BalanceCheck.DepthNode();

        assertTrue(check.isBalanced(node));
    }

    @Test
    public void three_nodes_tree_can_be_unbalanced() throws Exception {
        BalanceCheck check = new BalanceCheck();

        BalanceCheck.DepthNode node = new BalanceCheck.DepthNode();
        node.left = new BalanceCheck.DepthNode();
        node.left.left = new BalanceCheck.DepthNode();

        assertFalse(check.isBalanced(node));
    }

    @Test
    public void four_nodes_tree_can_be_unbalanced() throws Exception {
        BalanceCheck check = new BalanceCheck();

        BalanceCheck.DepthNode node = new BalanceCheck.DepthNode();
        node.left = new BalanceCheck.DepthNode();
        node.left.left = new BalanceCheck.DepthNode();
        node.left.right = new BalanceCheck.DepthNode();

        assertFalse(check.isBalanced(node));
    }

    @Test
    public void five_node_tree_is_balanced() throws Exception {
        BalanceCheck check = new BalanceCheck();

        BalanceCheck.DepthNode node = new BalanceCheck.DepthNode();
        node.right = new BalanceCheck.DepthNode();
        node.left = new BalanceCheck.DepthNode();
        node.left.left = new BalanceCheck.DepthNode();
        node.left.right = new BalanceCheck.DepthNode();

        assertTrue(check.isBalanced(node));
    }

}