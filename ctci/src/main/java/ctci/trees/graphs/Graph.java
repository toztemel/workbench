package ctci.trees.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Graph {
    GraphNode[] nodes;

    void depthFirstSearch(GraphNode root) {
        if (null == root) {
            return;
        }
        visit(root);
        Arrays.stream(root.children)
                .filter(n -> !n.visited)
                .forEach(this::depthFirstSearch);
    }

    private void visit(GraphNode root) {
        root.visited = true;
    }

    void breadthFirstSearch(GraphNode root) {
        Queue<GraphNode> queue = new LinkedList<>();
        enqueue(queue, root);
        while (!queue.isEmpty()) {
            GraphNode r = queue.poll();
            visit(r);
            Arrays.stream(r.children)
                    .forEach(node -> enqueue(queue, node));
        }
    }

    private void enqueue(Queue<GraphNode> queue, GraphNode node) {
        if (!node.isQueued) {
            node.isQueued = true;
            queue.add(node);
        }
    }

    public void createNode(String project) {

    }

    public void addEdge(String first, String second) {

    }

}
