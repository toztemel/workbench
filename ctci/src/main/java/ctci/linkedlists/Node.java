package ctci.linkedlists;

class Node {

    Node next = null;
    int data;

    Node(int d) {
        data = d;
    }

    static Node createList(int... datas) {
        Node head = new Node(datas[0]);
        for (int i = 1; i < datas.length; i++) {
            head.appendToTail(new Node(datas[i]));
        }
        return head;
    }

    static boolean equals(Node m, Node n) {
        while (m != null && n != null) {
            if (m.data != n.data) {
                return false;
            }
            m = m.next;
            n = n.next;
        }
        return m == null && n == null;
    }

    static Node from(int sum) {
        Node result = new Node(-1);
        int rem;
        while(sum != 0) {
            rem = sum%10;
            sum = sum/10;
            result.appendToTail(new Node(rem));
        }
        return result.next;
    }

    int getData() {
        return data;
    }

    Node appendToTail(Node n) {
        Node c = this;
        while (c.next != null) {
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

        while (n.next != null) {
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

    int toInt() {
        int result = 0;
        int powerOfTen = 0;

        Node n = this;
        while (n != null) {
            result += n.data * (Math.pow(10, powerOfTen));
            powerOfTen++;
            n = n.next;
        }
        return result;
    }
}
