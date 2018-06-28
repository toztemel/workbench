package ctci.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class ListOfDepths {

    ArrayList listOfDepths(BinaryTreeNode binaryTree) {

        Queue<NodeToList> queue = new LinkedList<>();
        DepthList list = new DepthList();
        queue.add(new NodeToList(list, binaryTree));

        traverse(queue, list);

        ArrayList<DepthList> result = new ArrayList<>();
        while (list != null) {
            result.add(list);
            list = list.next;
        }
        return result;
    }

    private void traverse(Queue<NodeToList> queue, DepthList list) {
        while (!queue.isEmpty()) {
            NodeToList poll = queue.poll();
            DepthList levelList = poll.list;
            BinaryTreeNode node = poll.node;
            list.add(node);

            DepthList childList;
            if (levelList.next == null) {
                childList = new DepthList();
            } else {
                childList = levelList.next;
            }


            if (node.left != null) {
                queue.add(new NodeToList(childList, node.left));
                if (levelList.next == null) {
                    levelList.next = childList;
                }
            }
            if (node.right != null) {
                queue.add(new NodeToList(childList, node.right));
                if (levelList.next == null) {
                    levelList.next = childList;
                }
            }
        }
    }

    class NodeToList {
        BinaryTreeNode node;
        DepthList list;

        NodeToList(DepthList l, BinaryTreeNode n) {
            list = l;
            node = n;
        }
    }

    class DepthList extends ArrayList<BinaryTreeNode> {
        DepthList next;
    }
}
