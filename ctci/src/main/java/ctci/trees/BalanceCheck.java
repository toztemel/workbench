package ctci.trees;

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
}
