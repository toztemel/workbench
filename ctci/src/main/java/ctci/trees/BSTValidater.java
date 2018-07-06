package ctci.trees;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Q: check if a binary tree is a BST
 */
class BSTValidater {

    boolean isBST(BinaryTreeNode node) {
        return checkBST(node, new Validator());
    }

    private boolean checkBST(BinaryTreeNode node, Validator validator) {
        if (node == null) {
            return true;
        }

        if (!validator.isInRange(node.data)) {
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


    /**
     * . in-order traversal
     * . copy elements to an array
     * . check if the array is sorted
     * . requires a little bit of extra memory
     * . can't handle duplicate values
     * .    . it cannot differenciate 20(child) -> 20(parent) vs 20(parent) -> 20(child)
     * . works if duplicate values are not allowed
     */
    private static class Solution1 {
        int index = 0; // keep track of logical end of the array

        boolean checkBST(TreeNode root, int size) {
            int[] array = new int[size];
            copyBST(root, array);
            for (int i = 1; i < array.length; i++) {
                if (array[i] <= array[i - 1]) {
                    return false;
                }
            }
            return true;
        }

        private void copyBST(TreeNode root, int[] array) {
            if (root == null) {
                return;
            }

            copyBST(root.left, array);
            array[index] = root.data;
            index++;
            copyBST(root.right, array);
        }
    }


    /**
     * . array is not necessary
     * . eliminate array
     * . just track the last element and compare
     */
    private static class Solution2 {

        Integer last_printed = null;

        boolean checkBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            // check / recurse left
            if (!checkBST(root.left))
                return false;

            // check current
            if (last_printed != null && root.data <= last_printed) {
                return false;
            }
            last_printed = root.data;
            //check / recurse right
            if (!checkBST(root.right)) {
                return false;
            }
            return true;
        }
    }

    /**
     * . left subtree <= current < right subtree
     * . pass down min and max values
     * . O( N ) time complexity
     * . O( logN ) space complexity on a balanced tree
     */
    private static class Solution3 {

        boolean checkBST(TreeNode root) {
            return checkBST(root, null, null);
        }

        private boolean checkBST(TreeNode root, Integer min, Integer max) {
            if (root == null) {
                return true;
            }
            if ((min != null && root.data <= min) || (max != null && root.data > max)) {
                return false;
            }

            if (!checkBST(root.left, min, root.data) || !checkBST(root.right, root.data, max)) {
                return false;
            }
            return true;
        }
    }
}
