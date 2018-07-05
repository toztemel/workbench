package ctci.trees.graphs;

import ctci.trees.graphs.BuildOrder.Dependencies;
import ctci.trees.graphs.BuildOrder.Dependency;
import ctci.trees.graphs.BuildOrder.Project;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static ctci.trees.graphs.BuildOrder.Projects;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BuildOrderTest {

    private BuildOrder order;
    private Dependencies dependencies;
    private Projects projects;

    @Before
    public void setUp() throws Exception {
        order = new BuildOrder();

        Project a = new Project("a");
        Project b = new Project("b");
        Project c = new Project("c");
        Project d = new Project("d");
        Project e = new Project("e");
        Project f = new Project("f");

        projects = new Projects();
        projects.add(a);
        projects.add(b);
        projects.add(c);
        projects.add(d);
        projects.add(e);
        projects.add(f);

        dependencies = new Dependencies();
        dependencies.add(new Dependency().of(d).to(a));
        dependencies.add(new Dependency().of(b).to(f));
        dependencies.add(new Dependency().of(d).to(b));
        dependencies.add(new Dependency().of(a).to(f));
        dependencies.add(new Dependency().of(c).to(d));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cylic_dependancy_throws_exception() throws Exception {

        Project q = new Project("q");
        Project x = new Project("x");
        Project w = new Project("w");

        Dependencies cyclicDependencies = new Dependencies();
        cyclicDependencies.add(new Dependency().of(x).to(q));
        cyclicDependencies.add(new Dependency().of(q).to(w));
        cyclicDependencies.add(new Dependency().of(w).to(x));

        Projects projects = new Projects();
        projects.add(x);
        projects.add(q);
        projects.add(w);

        order.findBuildOrder(projects, cyclicDependencies);
    }

    @Test
    public void findBuildOrder() throws Exception {

        Projects buildOrder = order.findBuildOrder(projects, dependencies);

        assertEquals(6, buildOrder.size());
        assertEquals("f", buildOrder.get(1).name);
        assertEquals("e", buildOrder.get(0).name);
        assertEquals("b", buildOrder.get(2).name);
        assertEquals("a", buildOrder.get(3).name);
        assertEquals("d", buildOrder.get(4).name);
        assertEquals("c", buildOrder.get(5).name);
    }

    @Test
    public void wide_project_list() {
        Project a = new Project("a");
        Project b = new Project("b");
        Project c = new Project("c");
        Project d = new Project("d");
        Project e = new Project("e");
        Project f = new Project("f");
        Project g = new Project("g");
        Project h = new Project("h");
        Project i = new Project("i");
        Project j = new Project("j");
        Project k = new Project("k");
        Project l = new Project("l");
        Project m = new Project("m");
        Project n = new Project("n");
        Project o = new Project("o");
        Project p = new Project("p");
        Project q = new Project("q");
        Project r = new Project("r");
        Projects projects = new Projects();
        projects.addAll(Arrays.asList(a, b, c, d, e, f, g,
                h, i, j, k, l, m, n, o, p, q, r));

        Dependencies dependencies = new Dependencies()
                .addDependency(new Dependency().of(a).to(d))
                .addDependency(new Dependency().of(a).to(c))
                .addDependency(new Dependency().of(b).to(h))
                .addDependency(new Dependency().of(b).to(f))
                .addDependency(new Dependency().of(c).to(b))
                .addDependency(new Dependency().of(c).to(f))
                .addDependency(new Dependency().of(c).to(e))
                .addDependency(new Dependency().of(e).to(m))
                .addDependency(new Dependency().of(e).to(l))
                .addDependency(new Dependency().of(f).to(k))
                .addDependency(new Dependency().of(f).to(g))
                .addDependency(new Dependency().of(g).to(i))
                .addDependency(new Dependency().of(g).to(j))
                .addDependency(new Dependency().of(h).to(i))
                .addDependency(new Dependency().of(i).to(n))
                .addDependency(new Dependency().of(j).to(o))
                .addDependency(new Dependency().of(k).to(n))
                .addDependency(new Dependency().of(k).to(j))
                .addDependency(new Dependency().of(k).to(p))
                .addDependency(new Dependency().of(l).to(o))
                .addDependency(new Dependency().of(m).to(p))
                .addDependency(new Dependency().of(n).to(r))
                .addDependency(new Dependency().of(p).to(o))
                .addDependency(new Dependency().of(p).to(o))
                .addDependency(new Dependency().of(p).to(r))
                .addDependency(new Dependency().of(q).to(p));

        Projects buildOrder = order.findBuildOrder(projects, dependencies);

        assertEquals(18, buildOrder.size());
        assertTrue(buildOrder.indexOf(d) == 0);
        assertTrue(buildOrder.indexOf(o) == 1);
        assertTrue(buildOrder.indexOf(r) == 2);
        assertTrue(buildOrder.indexOf(j) == 3);
        assertTrue(buildOrder.indexOf(l) == 4);
        assertTrue(buildOrder.indexOf(p) == 5);
        assertTrue(buildOrder.indexOf(n) == 6);
        assertTrue(buildOrder.indexOf(k) == 7);
        assertTrue(buildOrder.indexOf(m) == 8);
        assertTrue(buildOrder.indexOf(q) == 9);
        assertTrue(buildOrder.indexOf(i) == 10);
        assertTrue(buildOrder.indexOf(g) == 11);
        assertTrue(buildOrder.indexOf(f) == 12);
        assertTrue(buildOrder.indexOf(e) == 13);
        assertTrue(buildOrder.indexOf(h) == 14);
        assertTrue(buildOrder.indexOf(b) == 15);
        assertTrue(buildOrder.indexOf(c) == 16);
        assertTrue(buildOrder.indexOf(a) == 17);

    }
}