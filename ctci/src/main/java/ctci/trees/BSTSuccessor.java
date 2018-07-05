package ctci.trees;

public class BSTSuccessor {

    int findSuccessor(DoubleBSTNode node) {
        DoubleBSTNode successor;

        if (node.isRightAvailable()) {
            successor = minFromTree(node.right);
        } else {
            if (node.getParent().data == node.data + 1) {
                successor = node.getParent();
            } else if (node.getParent().right == node) {
                successor = minFromParents(node);
                if (successor.data <= node.data) {
                    successor = null;
                }
            } else {
                successor = node.getParent();
            }
        }

        return (null == successor) ? -1 : successor.data;
    }

    private DoubleBSTNode minFromParents(DoubleBSTNode node) {
        DoubleBSTNode parent = node;
        while (parent.data <= node.data) {
            if (parent.getParent() == null) {
                break;
            }
            parent = parent.getParent();
        }
        return parent;
    }

    private DoubleBSTNode minFromTree(BinaryTreeNode node) {
        return (node.isLeftAvailable()) ? minFromTree(node.left) : (DoubleBSTNode) node;
    }

    DoubleBSTNode goLeft(DoubleBSTNode node) {
        return (DoubleBSTNode) node.left;
    }

    DoubleBSTNode goRight(DoubleBSTNode node) {
        return (DoubleBSTNode) node.right;
    }

    DoubleBSTNode goUp(DoubleBSTNode node) {
        return node.getParent();
    }
}
