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
        int i = 0;
        while (last != null) {
            last = last.next;
            i++;
            if (i >= k) {
                kth = kth.next;
            }
        }
        return kth;
    }

}
