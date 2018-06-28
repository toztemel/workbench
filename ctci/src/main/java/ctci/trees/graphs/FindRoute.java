package ctci.trees.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindRoute {

    // Find if route exists in directed graph
    boolean routeExists(GraphNode source, GraphNode destination) {
        Queue<GraphNode> queue = new LinkedList<>();

        queue.add(source);

        while (!queue.isEmpty()) {
            GraphNode n = queue.poll();
            if (null != n) {
                if (n.name == destination.name) {
                    return true;
                }
                Arrays.stream(n.children)
                        .filter(child -> !child.isQueued)
                        .forEach(queue::add);
            }
        }
        return false;
    }
}
