package ctci.trees;

/**
 * Q: find the next(in-order successor) node of a given node in a BST
 * . node has a link to its parent
 */
class BSTSuccessor {

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

    /**
     * . if node has a right subtree, pick left-most node on the right subtree
     * . if node doesn't have a right subtree,
     * .    . move up to node's parent
     * .    . if n is left child of parent, next node should be parent
     * .    . if n is right child of parent, move upwards
     *
     * PSEUDO:
     * Node inorderSucc(Node n) {
     *     if ( n has right subtree) { return leftmost child of right subtree}
     *     else {
     *         while (n is a rightChild of n.parent) {
     *             n = n.parent; // go up
     *         }
     *         return n.parent
     *     }
     * }
     */
    private static class Solution {

        TreeNode inorderSucc(TreeNode n) {
            if (n == null) return null;

            /*
            Found right children -> return leftmost node
             */
            if (n.right != null) {
                return leftMostChild(n.right);
            } else {
                TreeNode q = n;
                TreeNode x = q.parent;
                // go up until we're on the left
                while (x != null && x.left != q) {
                    q = x;
                    x = x.parent;
                }
                return x;
            }
        }
        private TreeNode leftMostChild(TreeNode n) {
            if (n == null) return n;
            while(n.left!=null) {
                n = n.left;
            }
            return n;
        }
    }
}
