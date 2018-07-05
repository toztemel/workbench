package ctci.trees;

class BinaryTreeNode extends TreeNode {

    final int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int i) {

        data = i;
    }


    void preOrderTraversal(BinaryTreeNode node) {
        if (null != node) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    void inOrderTraversal(BinaryTreeNode node) {
        if (null != node) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(BinaryTreeNode node) {
        if (null != null) {
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
            visit(node);
        }
    }

    private void visit(BinaryTreeNode node) {

    }

    void addLeft(BinaryTreeNode l) {
        left = l;
    }

    void addRight(BinaryTreeNode r) {
        right = r;

    }

    boolean isSmaller(BinaryTreeNode child) {
        return child.data < data;
    }

    boolean isGreater(BinaryTreeNode child) {
        return child.data > data;
    }

    boolean isLeftAvailable() {
        return left != null;
    }

    boolean isRightAvailable() {
        return right != null;
    }
}
