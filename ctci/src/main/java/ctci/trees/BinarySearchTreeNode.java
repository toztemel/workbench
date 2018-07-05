package ctci.trees;

class BinarySearchTreeNode extends BinaryTreeNode {

    BinarySearchTreeNode(int i) {
        super(i);
    }

    void insertNode(BinaryTreeNode node) {
        BinarySearchTreeNode child = (BinarySearchTreeNode) node;
        if (isSmaller(child)) {
            if (isLeftAvailable()) {
                ((BinarySearchTreeNode)left).insertNode(child);
            } else {
                left = child;
            }
        } else if (isGreater(child)) {
            if (isRightAvailable()) {
                ((BinarySearchTreeNode)right).insertNode(child);
            } else {
                right = child;
            }
        } else {
            // ignore equality
        }
    }

}
