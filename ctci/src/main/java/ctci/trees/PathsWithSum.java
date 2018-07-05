package ctci.trees;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class PathsWithSum {

    private static AtomicInteger count = new AtomicInteger(0);

    int findPaths(BinaryTreeNode node, final int target) {

        find(node, target, new Sums());

        return count.getAndSet(0);
    }


    private void find(BinaryTreeNode root, final int target, Sums sums) {
        if (root == null) {
            return;
        }

        sums.addNewSum(root.data, target);

        Sums backup = sums.backup();

        find(root.left, target, sums);

        sums.restore(backup);

        find(root.right, target, sums);
    }

    private class Sums extends ArrayList<Sum> {

        void addNewSum(int data, final int target) {
            forEach(sum -> sum.increment(data));
            add(new Sum(data));
            stream()
                    .filter(s -> s.matches(target))
                    .forEach(s -> count.incrementAndGet());
        }

        void restore(Sums backup) {
            while (!isEmpty()) {
                remove(0);
            }
            backup.forEach(b -> add(new Sum(b.data)));
        }

        Sums backup() {
            Sums sums = new Sums();
            forEach(s -> sums.add(new Sum(s.data)));
            return sums;
        }
    }

    private class Sum {
        int data;

        Sum(int d) {
            data = d;
        }

        void increment(int d) {
            data += d;
        }

        boolean matches(int target) {
            return data == target;
        }

        @Override
        public boolean equals(Object s) {
            return (s instanceof Sum) && data == ((Sum) s).data;
        }

        @Override
        public int hashCode() {
            return System.identityHashCode(data);
        }
    }
}