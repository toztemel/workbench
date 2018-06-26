package ctci.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class LoopDetection {

    Node detectLoop(Node circularList) {
        Set<Node> set = new HashSet<>();
        while (circularList != null) {
            if (set.contains(circularList)) {
                return circularList;
            } else {
                set.add(circularList);
            }
            circularList = circularList.next;
        }
        return null;
    }
}
