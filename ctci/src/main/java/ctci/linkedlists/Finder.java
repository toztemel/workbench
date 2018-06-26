package ctci.linkedlists;

class Finder {

    int printLastKthValue(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printLastKthValue(head.next, k) + 1;
        if (k == index) {
            System.out.println(head.data);
        }
        return index;
    }

    Node findLastKthValue(Node head, int k) {
        Node last = head;
        Node kth = head;
        int i = 1;
        while (last != null && i <= k) {
            last = last.next;
            i++;
        }
        while (last != null) {
            last = last.next;
            kth = kth.next;
        }
        return kth;
    }

}
