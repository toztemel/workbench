package ctci.linkedlists;

public class Intersection {

    Node intersect(Node list1, Node list2) {
        while (list1 != null) {
            Node iter = list2;
            while (iter != null) {
                if (iter.equals(list1)) {
                    return iter;
                }
                iter = iter.next;
            }
            list1 = list1.next;
        }
        return null;
    }

    public Node intersectMulti(Node list1, Node list2) {
        return null;
    }
}
