package ctci.linkedlists;

import java.util.HashSet;
import java.util.Set;

class DuplicateRemover {

    /*
    takes O(N) time
     */
    void deleteDuplicates(Node head) {
        Set<Integer> set = new HashSet<>();
        Node previous = null, n = head;

        while(n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    /*
    takes O(N^2) time , O(1) space
     */
    void deleteDuplicatesWithoutBuffer(Node n) {
        Node current = n;

        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                }
                runner = runner.next;
            }
            current = current.next;
        }
    }

}
