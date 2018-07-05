package ctci.trees.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a directed graph, find out whether there is a route
 * between two nodes
 * <p>
 * Breadt-First search : can be used to find the shortest path
 * Depth-First search : traverse one adjacent node very deeply
 */
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

    static class Solution2 {
        boolean breadthFirstSearch(Graph g, Node start, Node end) {
            if (start == end) return true;

            LinkedList<Node> q = new LinkedList<>();
            for (Node u : g.nodes) {
                u.state = State.Unvisited;
            }
            start.state = State.Visiting;
            q.add(start);
            Node u;
            while (!q.isEmpty()) {
                u = q.removeFirst();
                if (u != null) {
                    for (Node v : u.getAdjacent()) {
                        if (v.state == State.Unvisited) {
                            if (v == end) {
                                return true;
                            }
                            v.state = State.Visiting.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
            return false;
        }

        enum State {Unvisited, Visited, Visiting}

        static class Node {
            Solution2.State state;

            public Node[] getAdjacent() {
                return null;
            }
        }

        static class Graph {
            Node[] nodes;
        }
    }


}
