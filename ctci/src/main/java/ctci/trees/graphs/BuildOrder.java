package ctci.trees.graphs;

import java.util.*;

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

}
