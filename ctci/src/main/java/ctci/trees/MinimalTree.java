package ctci.trees;

/**
 * Given a sorted(increasing order) array with unique integer elements,
 * create a binary search tree with minimal height
 */
public class MinimalTree {


    /**
     * . inserts child through a recursive process, starting from the root
     * . Inefficient
     * . Each insertion requires tree traversal
     * . total cost of O( N logN )
     */
    BinaryTreeNode toBinarySearchTree(int[] ascendingArray) {

        int mid = ascendingArray.length / 2;
        BinarySearchTreeNode root = new BinarySearchTreeNode(ascendingArray[mid]);

        for (int i = 0; i < ascendingArray.length; i++) {
            if (i == root.data) {
                continue;
            }
            BinaryTreeNode child = new BinaryTreeNode(i);
            root.insertNode(child);
        }

        return root;
    }


    private static class Solution {
        /**
         * match the number of nodes in the left subtree to the number of nodes in the right subtree
         *
         * root to be the middle of the array, one half is smaller, one half is greater
         *
         * 1. insert into the tree the middle element o the array
         * 2. insert in to left subtree the left subarray elements
         * 3. insert in to right subtree the right subarray elements
         * 4. Recurse
         */

        TreeNode createMinimalBST(int array[]) {
            return createMinimalBST(array, 0, array.length-1);
        }

        private TreeNode createMinimalBST(int[] arr, int start, int end) {
            if (end < start ) {
                return null;
            }
            int mid = (start+end)/2;
            TreeNode n = new TreeNode(arr[mid]);
            n.left = createMinimalBST(arr, start, mid-1);
            n.right = createMinimalBST(arr, mid+1, end);
            return n;
        }
    }
}
