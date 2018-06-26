package ctci.stacks;

import java.util.Stack;

public class SetOfStacks {

    private final int stackCapacity;
    private Stack<Stack<Integer>> stackOfStacks = new Stack<>();

    SetOfStacks(int capacity) {
        stackCapacity = capacity;
    }

    void push(Integer i) {
        if (isEmpty()) {
            addNewStack();
        }
        Stack<Integer> topStack = getTopStack();
        if (isFull(topStack)) {
            addNewStack();
        }
        getTopStack().push(i);
    }

    private boolean isFull(Stack<Integer> stack) {
        return stack.size() == stackCapacity;
    }

    private void addNewStack() {
        stackOfStacks.push(new Stack<>());
    }

    private Stack<Integer> getTopStack() {
        return stackOfStacks.peek();
    }

    Integer pop() {
        Stack<Integer> stack = getTopStack();
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            removeStack();
        }
        return result;
    }

    private Stack<Integer> removeStack() {
        return stackOfStacks.pop();
    }

    private void pushStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            push(stack.pop());
        }
    }

    Integer peek() {
        return getTopStack().peek();
    }

    boolean isEmpty() {
        return stackOfStacks.isEmpty();
    }

    Integer popAt(int stackIndex) {
        int stackSize = stackOfStacks.size();
        Stack<Stack<Integer>> tempStacks = new Stack<>();
        for (int j = 1; j < stackSize - stackIndex; j++) {
            tempStacks.push(removeStack());
        }

        Integer result = getTopStack().pop();
        while (!tempStacks.isEmpty()) {
            Stack<Integer> reverseOrder = reverseAndEmpty(tempStacks.pop());
            pushStack(reverseOrder);
        }
        return result;
    }

    Stack<Integer> reverseAndEmpty(Stack<Integer> stack) {
        Stack<Integer> reverseOrder = new Stack<>();
        while (!stack.isEmpty()) {
            reverseOrder.push(stack.pop());
        }
        return reverseOrder;
    }
}
