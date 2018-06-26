package ctci.linkedlists;

class Summation {

    Node sum(Node node1, Node node2) {
        int num1 = node1.toInt();
        int num2 = node2.toInt();
        int sum = num1 + num2;

        return Node.from(sum);
    }
}
