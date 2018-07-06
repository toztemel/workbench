package ctci.trees;

// TODO fix if b1 < b2

/**
 * find the first common ancestor of two nodes in a binary tree
 * avoid storing additional nodes in a data structure
 */
class FirstCommonAncestor {

    BinaryTreeNode find(BinaryTreeNode root, BinaryTreeNode b1, BinaryTreeNode b2) {

        boolean left = includes(root.left, b1);
        boolean right = includes(root.right, b2);
        if (left && right) {
            return root;
        } else if (left) {
            return find(root.left, b1, b2);
        }
        return find(root.right, b1, b2);
    }

    private boolean includes(BinaryTreeNode root, BinaryTreeNode target) {
        if (root == null) {
            return false;
        }

        if (root.data == target.data) {
            return true;
        }

        return includes(root.left, target) || includes(root.right, target);
    }

    /**
     * if Nodes have links to their parents
     * <p>
     * . takes O( d ) time, d:depth
     */
    private static class Solution1 {
        TreeNode commonAncestor(TreeNode p, TreeNode q) {
            int delta = depth(p) - depth(q);
            TreeNode first = delta > 0 ? q : p;
            TreeNode second = delta > 0 ? p : q;
            second = goUpBy(second, Math.abs(delta));

            while (first != second && first != null && second != null) {
                first = first.parent;
                second = second.parent;
            }
            return first == null || second == null ? null : first;
        }

        private TreeNode goUpBy(TreeNode node, int delta) {
            while (delta > 0 && node != null) {
                node = node.parent;
                delta--;
            }
            return node;
        }

        private int depth(TreeNode p) {
            int depth = 0;
            while (p != null) {
                p = p.parent;
                depth++;
            }
            return depth;
        }
    }

    /**
     * Better WorstCase runtime
     * <p>
     * trace upwards from p, check if a parent covers q
     * O( t ) time, t: size of subtree for the first common ancestor
     * O( n ) time : worst case
     */
    private static class Solution2 {
        TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (!covers(root, p) || !covers(root, q)) {
                return null;
            } else if (covers(p, q)) {
                return p;
            } else if (covers(q, p)) {
                return p;
            }
            TreeNode sibling = getSibling(p);
            TreeNode parent = p.parent;
            while (!covers(sibling, q)) {
                sibling = getSibling(parent);
                parent = parent.parent;
            }
            return parent;
        }

        private boolean covers(TreeNode root, TreeNode p) {
            if (root == null) return false;
            if (root == p) return true;
            return covers(root.left, p) || covers(root.right, p);
        }

        private TreeNode getSibling(TreeNode node) {
            if (node == null || node.parent == null) {
                return null;
            }
            TreeNode parent = node.parent;
            return parent.left == node ? parent.right : parent.left;
        }
    }

    /**
     * Without links to parents
     * <p>
     * follow a chain in which p and q are on the same side
     * if both on the right, go right
     * if both on the left, go left
     * O( n ) time on a balanced tree. it covers 2n nodes  first, then branches out and covers 2n/2, 2n/4 nodes
     */
    private static class Solution3 {
        TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (!covers(root, p) || !covers(root, q)) {
                return null;
            }
            return ancestorHelper(root, p, q);
        }

        private TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            boolean pIsOnLeft = covers(root.left, p);
            boolean qIsOnLeft = covers(root.left, q);
            if (pIsOnLeft != qIsOnLeft) {
                return root;
            }
            TreeNode childSide = pIsOnLeft ? root.left : root.right;
            return ancestorHelper(childSide, p, q);
        }

        private boolean covers(TreeNode root, TreeNode p) {
            if (root == null) return false;
            if (root == p) return true;
            return covers(root.left, p) || covers(root.right, p);

        }
    }

    /**
     * Optimized
     *
     * Constraint: both nodes has to be in the tree
     *
     * covers doesn't search each subtree over and over again
     * search entire tree only once
     * bubble up the findings to earlier nodes
     * recurse through entire tree with a function
     * function
     * returns p, if root's subtree includes only p
     * returns q, if root's subtree includes only q
     * returs null, if neither is included
     * returns the common ancestor of p and q
     */
    private static class Solution4 {
        TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root == p && root == q) return root;

            TreeNode x = commonAncestor(root.left, p, q);
            if (null != x && x != p && x != q) {
                return x; // already found the ancestor
            }

            TreeNode y = commonAncestor(root.right, p, q);
            if (null != y && y != p && y != q) {
                return y; // already found the ancestor
            }

            if (x != null && y != null) {
                //p and q found in different subtrees
                return root;
            } else if (root == p || root == q) {
                return root;
            }
            return x == null ? y : x; // return non-null value
        }
    }
}