package ctci.trees;

public class MinimalTree {

    BinaryTreeNode toBinarySearchTree(int[] ascendingArray) {

        int mid = ascendingArray.length / 2;
        BinaryTreeNode root = new BinaryTreeNode(ascendingArray[mid]);

        for (int i = 0; i < ascendingArray.length; i++) {
            if (i == root.data) {
                continue;
            }
            BinaryTreeNode child = new BinaryTreeNode(i);
            root.addChild(child);
        }

        return root;
    }
}
