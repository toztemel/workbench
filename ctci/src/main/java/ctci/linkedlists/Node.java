package ctci.linkedlists;

class Node {

    Node next = null;
    int data;

    static Node createList(int... datas) {
        Node head = new Node(datas[0]);
        for (int i = 1; i < datas.length; i++) {
            head.appendToTail(new Node(datas[i]));
        }
        return head;
    }

    static boolean equals (Node m, Node n) {
        while(m.next != null && n.next!=null) {
            if (m.data == n.data) {
                m = m.next;
                n = n.next;
            } else {
                return false;
            }
        }
        if (m.next != null ) {
            return false;
        }
        if (n.next != null) {
            return false;
        }
        return true;
    }

    Node(int d) {
        data = d;
    }

    int getData() {
        return data;
    }

    Node appendToTail(Node n) {
        Node c = this;
        while(c.next != null) {
            c = c.next;
        }
        c.next = n;
        return this;
    }

    Node deleteNode(Node head, int d) {

        Node n = head;

        if (n.data == d) {
            return n.next;
        }

        while(n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }

        return head;
    }

    String printList() {
        StringBuilder sb = new StringBuilder(String.valueOf(data));

        Node n = next;
        while (n != null) {
            sb.append("-" + n.data);
            n = n.next;
        }
        return sb.toString();
    }

}
