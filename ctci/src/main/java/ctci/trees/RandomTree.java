package ctci.trees;

import java.util.Random;

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

    private static int generateRandomInt() {
        return new Random().nextInt(totalCount);
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

}
