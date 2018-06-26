package ctci.stacks;

import java.util.Stack;

class StackWithMin extends Stack<StackWithMin.StackNode> {

    private StackNode top;

    void push(int t) {
        StackNode node = new StackNode(t, Math.min(top.min, t));
        super.push(node);
    }

    int min() {
        if (isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return super.peek().min;
    }

    class StackNode {
        private int data;
        private int min;

        StackNode(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }
}
