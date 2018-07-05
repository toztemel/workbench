package ctci.trees;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class BSTValidater {

    boolean isBST(BinaryTreeNode node) {
        return checkBST(node, new Validator());
    }

    private boolean checkBST(BinaryTreeNode node, Validator validator) {
        if (node == null) {
            return true;
        }

        if (!validator.isInRange(node.data)){
            return false;
        }

        boolean result = true;

        if (null != node.left) {
            result = (node.data > node.left.data);
        }
        if (result && null != node.right) {
            result = node.data < node.right.data;
        }

        if (result) {
            validator.addGreater(node.data);
            result = checkBST(node.left, validator);
            validator.removeGreater(node.data);
        }
        if (result) {
            validator.addSmaller(node.data);
            result = checkBST(node.right, validator);
            validator.removeSmaller(node.data);
        }
        return result;
    }

    private static class Validator {
        Set<Integer> smaller = new HashSet<>();
        Set<Integer> greater = new HashSet<>();

        boolean isInRange(int value) {

            List<Integer> notSmaller = smaller.stream()
                    .filter(i -> i > value)
                    .collect(Collectors.toList());
            if (!notSmaller.isEmpty()) {
                return false;
            }

            List<Integer> notGreater = greater.stream()
                    .filter(i -> i < value)
                    .collect(Collectors.toList());

            return notGreater.isEmpty();
        }

        void addGreater(int data) {
            greater.add(data);
        }
        void addSmaller(int data) {
            smaller.add(data);
        }
        void removeGreater(int data) {
            greater.remove(data);
        }
        void removeSmaller(int data) {
            smaller.remove(data);
        }
    }
}
