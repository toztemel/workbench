package ctci.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Question: given a binary tree, create a linked list of all nodes at each depth
 * <p>
 * . appears at first : level-by-level traversal
 * . both ways can be applied provided that current depth is known
 */
class ListOfDepths {

    ArrayList listOfDepths(BinaryTreeNode binaryTree) {

        Queue<NodeListPair> queue = new LinkedList<>();
        ListOfNodes list = new ListOfNodes();
        queue.add(new NodeListPair(list, binaryTree));

        traverse(queue, list);

        ArrayList<ListOfNodes> result = new ArrayList<>();
        while (list != null) {
            result.add(list);
            list = list.next;
        }
        return result;
    }

    private void traverse(Queue<NodeListPair> queue, ListOfNodes list) {
        while (!queue.isEmpty()) {
            NodeListPair poll = queue.poll();
            ListOfNodes levelList = poll.list;
            BinaryTreeNode node = poll.node;
            list.add(node);

            ListOfNodes childList;
            if (levelList.next == null) {
                childList = new ListOfNodes();
            } else {
                childList = levelList.next;
            }


            if (node.left != null) {
                queue.add(new NodeListPair(childList, node.left));
                if (levelList.next == null) {
                    levelList.next = childList;
                }
            }
            if (node.right != null) {
                queue.add(new NodeListPair(childList, node.right));
                if (levelList.next == null) {
                    levelList.next = childList;
                }
            }
        }
    }

    private static class NodeListPair {
        BinaryTreeNode node;
        ListOfNodes list;

        NodeListPair(ListOfNodes l, BinaryTreeNode n) {
            list = l;
            node = n;
        }
    }

    private static class ListOfNodes extends ArrayList<BinaryTreeNode> {
        ListOfNodes next;
    }

    /**
     * . Both run O(N) time
     * . BFS is more space efficient
     * . DFS uses extra O(logN) recursive calls
     * . both are equally efficient
     */
    private static class SolutionDepthFirstSearch {
        ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
            ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
            createLevelLinkedList(root, lists, 0);
            return lists;
        }
        private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
            if (root == null) {
                return;
            }
            LinkedList<TreeNode> list = null;
            if (lists.size() == level) { // level not contained in the list
                list = new LinkedList<>();
                lists.add(list);
            } else {
                list = lists.get(level);
            }
            list.add(root);
            createLevelLinkedList(root.left, lists, level+1);
            createLevelLinkedList(root.right, lists, level+1);
        }

    }

    private static class SolutionBreadtFirstSearch {

        ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
            ArrayList result = new ArrayList();
            LinkedList<TreeNode> current = new LinkedList<>();
            if (root != null) {
                current.add(root);
            }
            while (current.size() > 0) {
                result.add(current); // add previous level
                LinkedList<TreeNode> parents = current;// go to next level
                current = new LinkedList<>();
                for (TreeNode parent : parents) {
                    if (parent.left!=null) {
                        current.add(parent.left);
                    }
                    if (parent.right!=null) {
                        current.add(parent.right);
                    }
                }
            }
            return result;
        }
    }


}
