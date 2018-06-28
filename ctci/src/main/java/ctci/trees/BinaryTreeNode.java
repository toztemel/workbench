package ctci.trees;

class BinaryTreeNode {

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

    void addChild(BinaryTreeNode child) {
        if (isSmaller(child)) {
            if (isLeftAvailable()) {
                left.addChild(child);
            } else {
                left = child;
            }
        } else if (isGreater(child)) {
            if (isRightAvailable()) {
                right.addChild(child);
            } else {
                right = child;
            }
        } else {
            // ignore equality
        }
    }

    private boolean isSmaller(BinaryTreeNode child) {
        return child.data < data;
    }

    private boolean isGreater(BinaryTreeNode child) {
        return child.data > data;
    }

    boolean isLeftAvailable() {
        return left != null;
    }

    boolean isRightAvailable() {
        return right != null;
    }
}
