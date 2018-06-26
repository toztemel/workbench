package ctci.stacks;

import java.util.Stack;

class StackWithMin2 extends Stack<Integer> {

    private Stack<Integer> minStack;

    public StackWithMin2() {
        minStack = new Stack<>();
    }

    public Integer push(Integer value) {
        if (value <= min()) {
            minStack.push(value);
        }
        return super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            minStack.pop();
        }
        return value;
    }

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }

}
