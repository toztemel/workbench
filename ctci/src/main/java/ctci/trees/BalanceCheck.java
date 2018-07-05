package ctci.trees;

/**
 * check if a binary tree is balanced
 * (i.e. heights of two subtrees of any node never differ by more than one)
 */
class BalanceCheck {

    // Balanced Tree: the heights of the two subtrees never differ by more than one
    boolean isBalanced(DepthNode node) {

        if (null == node) {
            return true;
        }
        if (!isBalanced(node.left)) {
            return false;
        }
        if (!isBalanced(node.right)) {
            return false;
        }
        int rightDepth = (null == node.right) ? 0 : node.right.depth;
        int leftDepth = (null == node.left) ? 0 : node.left.depth;
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        node.depth = 1 + Math.max(leftDepth, rightDepth);
        return true;
    }

    static class DepthNode {
        DepthNode left;
        DepthNode right;
        int depth;
    }

    /**
     * . not efficient
     * . getHeight is repeatedly called on the same nodes
     * . O( N logN )
     */
    private static class Solution {
        private int getHeight(TreeNode root) {
            if (root == null) return -1;
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }

        boolean isBalanced(TreeNode root) {
            if (root == null) return true;

            int heightDiff = getHeight(root.left) - getHeight(root.right);
            if (Math.abs(heightDiff) > 1) return false;
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

    /**
     * . O( N ) time
     * . O( H ) space (H:height)
     */
    private static class Solution2 {
        int checkHeight(TreeNode root) {
            if (root == null) return -1;

            int leftHeight = checkHeight(root.left);
            if (leftHeight == Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            int rightHeight = checkHeight(root.right);
            if (rightHeight == Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            int heightDiff = leftHeight - rightHeight;
            if (Math.abs(heightDiff) > 1) return Integer.MIN_VALUE;
            return Math.max(leftHeight, rightHeight) + 1;
        }

        boolean isBalanced(TreeNode root) {
            return checkHeight(root) != Integer.MIN_VALUE;
        }
    }

}
