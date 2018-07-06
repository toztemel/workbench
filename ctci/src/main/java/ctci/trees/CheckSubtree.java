package ctci.trees;

/**
 * T1 and T2 are two large binary trees
 * T1 is much bigger than T2
 * find if T2 is a subtree of T15
 */
public class CheckSubtree {

    boolean isSubtree(BinaryTreeNode tree1, BinaryTreeNode tree2) {

        if (tree1 == null) {
            return false;
        }
        boolean result = false;

        if (tree1.data == tree2.data) {
            result = checkEqual(tree1, tree2);
        }

        if (!result) {
            result = isSubtree(tree1.left, tree2);
        }

        if (!result) {
            result = isSubtree(tree1.right, tree2);
        }

        return result;
    }

    private boolean checkEqual(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        } else if (root2 == null) {
            return false;
        }

        return root1.data == root2.data
                && checkEqual(root1.left, root2.left)
                && checkEqual(root1.right, root2.right);
    }

    /**
     * traverse the tree
     * convert to string array
     * compare two strings
     *
     * in-order traversal does not work
     * use pre-order traversal (root first)
     * put X instead of null values
     *
     * O( m + n ) time
     * O( m + n ) space
     */
    private static class Solution1 {

        boolean containsTree(TreeNode t1, TreeNode t2) {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();

            getOrderString(t1, s1);
            getOrderString(t2, s2);

            return s1.indexOf(s2.toString()) != -1;
        }

        private void getOrderString(TreeNode node, StringBuilder stringBuilder) {
            if (node == null) {
                stringBuilder.append("X");
                return;
            }
            stringBuilder.append(node.data + " ");
            getOrderString(node.left, stringBuilder);
            getOrderString(node.right, stringBuilder);
        }
    }

    /**
     * to reduce space complexity:
     *
     * search through the larget tree
     * each time a node maches root of the second tree, try to matchTree
     *
     * runtime: O( nm ) or more precisely O ( n + km) where
     *  k: number of occurences of tree2.root
     *
     * even so, matchTree exits without checking all nodes
     *
     */
    private static class Solution2 {

        boolean containsTree(TreeNode t1, TreeNode t2) {
            if (t2 == null) return true;
            return subtree(t1, t2);
        }

        private boolean subtree(TreeNode t1, TreeNode t2) {
            if (t1 == null) return false;
            if (t1.data == t2.data && matchTree(t1, t2)) return true;

            return subtree(t1.left, t2) || subtree(t1.right, t2);
        }

        private boolean matchTree(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null)
                return true;

            if (t1 == null || t2 == null)
                return false;

            if (t1.data != t2.data)
                return false;

            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }

    /**
     * Solution 1
     *  takes O(n+m) memory
     *  O(n+m) time
     * Solution 2
     *  takes O(logn + logm) memory
     *  O(nm) time in worst case
     *  O(n+km) time on average
     *
     *  So it is
     *  prioritizing average time vs worst-case runtime performance
     */
}
