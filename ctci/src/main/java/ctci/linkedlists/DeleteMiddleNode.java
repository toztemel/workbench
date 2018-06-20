package ctci.linkedlists;

public class DeleteMiddleNode {

    void deleteMiddleNode(Node n) {

        Node current = n;

        while(current.next.next != null) {
            current.data = current.next.data;
            current = current.next;
        }

        current.next = null;
    }
}
