package ctci.trees;

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

}
