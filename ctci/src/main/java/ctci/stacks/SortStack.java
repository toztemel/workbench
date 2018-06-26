package ctci.stacks;

import java.util.Stack;

class SortStack {

    /**
     * O(N^2) time
     * O(N) space
     */
    void sort(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            Integer value = stack.pop();

            while (!temp.isEmpty() && temp.peek() > value) {
                stack.push(temp.pop());
            }
            temp.push(value);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

    }
}