package ctci.linkedlists;

import java.util.Stack;

class Palindrome {

    /**
     * Reverses the list.
     * Compares with the original
     */
    boolean isPalindrome(Node aList) {
        Node revList = reverse(aList);
        return Node.equals(aList, revList);
    }

    private Node reverse(Node aList) {
        Node list = aList;
        Node revList = null;
        while (list != null) {
            Node currentNode = new Node(list.data);
            if (null == revList) {
                revList = currentNode;
            } else {
                currentNode.next = revList;
                revList = currentNode;
            }
            list = list.next;
        }
        return revList;
    }

    /**
     * Using Fast & Slow runners, pushs first half
     * of the list to a Stack
     */
    boolean isPalindrome2(Node head) {
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // if list has odd number of items, skip the middle
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();
            if(top != slow.data) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
