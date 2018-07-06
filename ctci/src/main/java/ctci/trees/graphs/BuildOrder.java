package ctci.trees.graphs;

import java.util.*;

/**
 * Q: given a list of projects and a list of dependencies, find a build order
 */
class BuildOrder {

    Projects findBuildOrder(Projects projects, Dependencies dependencies) {
        Queue<Project> buildOrder = new LinkedList<>();
        buildOrder.addAll(projects);

        Set<Project> dependants = new HashSet<>();
        dependencies.forEach(dep -> dependants.add(dep.dependant));
        buildOrder.removeAll(dependants);

        if (buildOrder.isEmpty()) {
            throw new IllegalArgumentException("Cyclic dependency");
        }

        Deque<Project> processing = new LinkedList<>();
        buildOrder.forEach(p -> processing.addAll(p.dependants));

        while (!processing.isEmpty()) {
            Project project = processing.poll();

            if (buildOrder.contains(project)) {
                continue;
            } else if (project.isReady(buildOrder)) {
                buildOrder.add(project);
                project.dependants.stream()
                        .filter(p -> !processing.contains(p))
                        .forEach(processing::addLast);
            } else {
                processing.addLast(project);
            }

        }

        return new Projects(buildOrder);

    }

    static class Dependencies extends ArrayList<Dependency> {
        Dependencies addDependency(Dependency d) {
            add(d);
            return this;
        }
    }

    static class Dependency {
        Project dependant;
        Project dependency;

        Dependency() {

        }

        Dependency of(Project dependant) {
            this.dependant = dependant;
            return this;
        }

        Dependency to(Project dependency) {
            this.dependency = dependency;
            this.dependency.hasDependencyFrom(dependant);
            this.dependant.dependsOn(this.dependency);
            return this;
        }

    }


    static class Projects extends ArrayList<Project> {

        Projects() {
        }

        Projects(Queue<Project> buildOrder) {
            this.addAll(buildOrder);
        }
    }

    static class Project extends GraphNode {
        Projects dependants;
        Projects dependencies;

        Project(String a) {
            name = a;
            dependants = new Projects();
            dependencies = new Projects();
        }

        private void hasDependencyFrom(Project dependant) {
            dependants.add(dependant);
        }

        void dependsOn(Project dependency) {
            dependencies.add(dependency);
        }

        boolean isReady(Queue<Project> buildOrder) {
            return buildOrder.containsAll(dependencies);
        }
    }

    /**
     * . visualize the problem
     * .    . A->B: B depends on A. A must be built first
     * . watchout
     * .    . arrow directions
     * .    . multiple dependencies
     * .    . random nodes
     * .    . graph of separate parts
     */

    /**
     * . find independent nodes in the graph
     * .    . if no independent nodes -> cyclic dependency error
     * . remove their edges
     * . recurse
     * . O( P + D ) time (# of projects and dependency pairs)
     * . Topological Sort Algorithm
     */
    private static class Solution1 {

        private static final Project[] CIRCULAR_DEPENDENCY_ERROR = null;

        private static class Project{}

        Project[] findBuildOrder (String[] projects, String[][] dependencies) {
            Graph graph = buildGraph(projects, dependencies);
            return orderProjects(getNodes(graph));
        }

        private ArrayList<Project> getNodes(Graph graph) {
            return null;
        }

        Graph buildGraph(String[] projects, String[][] dependencies) {
            Graph graph = new Graph();
            for (String project : projects) {
                graph.createNode(project);
            }
            for (String[] dependency : dependencies) {
                String first = dependency[0];
                String second = dependency[1];
                graph.addEdge(first, second);
            }
            return graph;
        }
        Project[] orderProjects(ArrayList<Project> projects) {
            Project[] order = new Project[projects.size()];

            int endOfList = addIndependent(order, projects, 0);

            int toBeProcessed = 0;
            while (toBeProcessed < order.length) {
                Project current = order[toBeProcessed];

                if (current == null) {
                    return CIRCULAR_DEPENDENCY_ERROR;
                }
                ArrayList<Project> children = getChildren(current);
                for (Project child : children) {
                    decrementDependencies(child);
                }

                endOfList = addIndependent(order, children, endOfList);
                toBeProcessed++;
            }
            return order;
        }

        private int addIndependent(Project[] order, ArrayList<Project> projects, int offset) {
            for (Project project : projects) {
                if (getNumberOfDependencies(project) ==0 ) {
                    order[offset] = project;
                    offset++;
                }
            }
            return offset;
        }

        private int getNumberOfDependencies(Project project) {
            return 0;
        }

        private void decrementDependencies(Project child) {

        }

        private ArrayList<Project> getChildren(Project current) {
            return null;
        }
    }

    /**
     * . Depth-first search
     *
     */
    private static class Solution2 {

    }
}
