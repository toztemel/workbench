package ctci.trees;

import java.util.ArrayList;
import java.util.List;

public class BSTSequences {

    Results findPossibleSequences(BinarySearchTreeNode root) {
        List<BinarySearchTreeNode> order = new ArrayList<>();
        order.add(root);
        Results rightOrder = findPossibleSequences((BinarySearchTreeNode) root.right);
        Results leftOrder = findPossibleSequences((BinarySearchTreeNode) root.left);
        return mix(root, rightOrder, leftOrder);

    }

    private Results mix(BinarySearchTreeNode root, Results rightOrder, Results leftOrder) {
        Results results = new Results(root);
        results.inject(rightOrder, leftOrder);
        results.inject(leftOrder, rightOrder);
        return results;
    }

    private class Results extends ArrayList<Result> {
        private BinarySearchTreeNode root;

        Results(BinarySearchTreeNode root) {
            this.root = root;
        }

        void inject(Results base, Results injecting) {
            for (int i = 0; i < base.size(); i++) {

            }
        }
    }

    private class Result extends ArrayList<BinarySearchTreeNode> {
    }
}
