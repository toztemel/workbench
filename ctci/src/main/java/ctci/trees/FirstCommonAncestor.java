package ctci.trees;

// TODO fix if b1 < b2
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

        if (root.data == target.data){
            return true;
        }

        return includes(root.left, target) || includes(root.right, target);
    }

}
