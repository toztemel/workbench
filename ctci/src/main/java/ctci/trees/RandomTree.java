package ctci.trees;

import java.util.Random;

/**
 * a BST with methods
 * insert
 * find
 * delete
 * getRandomNode -> returns random node from tree. all nodes are equally random
 */
class RandomTree {

    private static int totalCount;

    private RandomTree parent;
    private RandomTree left;
    private RandomTree right;
    private int data;
    private int leftChildrenCount;
    private int rightChildrenCount;

    private RandomTree() {
    }

    private static synchronized void decrementTotalCount() {
        totalCount--;
    }

    private static synchronized void incrementTotalCount() {
        totalCount++;
    }

    private static int generateRandomInt() {
        return new Random().nextInt(totalCount);
    }

    void insert(RandomTree parent, RandomTree newNode) throws Exception {
        if (!parent.hasLeft()) {
            parent.addLeft(newNode);
        } else if (!parent.hasRight()) {
            newNode.addRight(parent);
        }

        incrementTotalCount();
    }

    private boolean hasLeft() {
        return left != null;
    }

    private boolean hasRight() {
        return right != null;
    }

    void delete(RandomTree node) throws Exception {
        RandomTree parent = node.parent;
        node.parent = null;

        if (node.hasRight() || node.hasLeft()) {
            throw new Exception("Not empty");
        }

        while (null != parent) {
            if (parent.left == node) {
                parent.deleteLeft();
            } else {
                parent.deleteRight();
            }
            node = parent;
            parent = node.parent;
        }
        decrementTotalCount();
    }

    private void addRight(RandomTree node) throws Exception {
        right = node;
        rightChildrenCount++;
        notifyParents();
    }

    private void notifyParents() throws Exception {
        RandomTree p = this.parent;
        RandomTree c = this;
        while (p != null) {
            p.incrementChildrenCount(c);
            c = p;
            p = p.parent;
        }
    }

    private void incrementChildrenCount(RandomTree c) throws Exception {
        if (left == c) {
            leftChildrenCount++;
        } else if (right == c) {
            rightChildrenCount++;
        } else {
            throw new Exception("No such children");
        }
    }

    private void deleteRight() {
        rightChildrenCount--;
        right = null;
    }

    private void addLeft(RandomTree node) throws Exception {
        left = node;
        leftChildrenCount++;
        notifyParents();
    }

    private void deleteLeft() {
        leftChildrenCount--;
        left = null;
    }

    RandomTree find(int value) {
        return depthFirstSearch(this, value);
    }

    private RandomTree depthFirstSearch(RandomTree node, int value) {
        if (node.data == value) {
            return node;
        }

        RandomTree result = null;
        if (node.hasLeft()) {
            result = depthFirstSearch(node.left, value);
        }
        if (result == null && node.hasRight()) {
            result = depthFirstSearch(node.right, value);
        }
        return result;
    }

    RandomTree getRandomRandomTree() {
        return getNodeByWeight(this, generateRandomInt());
    }

    RandomTree getNodeByWeight(RandomTree root, int weight) {
        if (weight == 1) {
            return root;
        }
        if (weight <= root.leftChildrenCount) {
            return getNodeByWeight(root.left, weight - 1);
        } else {
            return getNodeByWeight(root.right, weight - 1 - root.leftChildrenCount);
        }
    }

    /**
     * Option #1 copy nodes to array, return random element. O(N) time and space
     * Option #2 maintain an array. => node deletion cause problem o(N) time
     * Option #3 label nodes => has similar problems with insert and delete
     * Option #4 use depth of the tree. pick random depth, go left or right => breaks equal random chances
     * Option #5 traverse down. at each node 1/3 stay - 1/3 go left - 1/3 go right => breaks randomness
     * Option #6 probability of each node should be 1/N.
     * probability of going left should be left_size * 1/N
     * probability of going right should be right_size * 1/N
     * each node must know the size of its left and right subtrees
     *
     * O(logN)
     */
    private static class Solution6 {
        class TreeNode {
            private int data;
            private int size;
            private TreeNode left;
            private TreeNode right;

            TreeNode(int d) {
                data = d;
                size = 1;
            }

            TreeNode getRandomNode() {
                int leftSize = left == null ? 0 : left.size();
                Random random = new Random();
                int index = random.nextInt(size);
                if (index < leftSize) {
                    return left.getRandomNode();
                } else if (index == leftSize) {
                    return this;
                } else {
                    return right.getRandomNode();
                }
            }

            void insertInOrder(int d) {
                if (d <= data) {
                    if (left == null) left = new TreeNode(d);
                    else left.insertInOrder(d);
                } else {
                    if (right == null) right = new TreeNode(d);
                    else right.insertInOrder(d);
                }
                size++;
            }

            private int size() {
                return size;
            }
            TreeNode find(int d) {
                if (d == data) return this;
                else if (d <= data) return left != null? left.find(d):null;
                else if (d > data) return right != null? right.find(d):null;
                return null;
            }
        }

    }

    /**
     * Option #7 random calls are expensive.
     * call random generation once.
     * subtract the remaining size from random number
     * pass the random number to subtree
     */
}
