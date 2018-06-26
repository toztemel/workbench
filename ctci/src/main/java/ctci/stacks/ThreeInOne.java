package ctci.stacks;

import java.util.EmptyStackException;

/**
 * Three stack in one array
 */
public class ThreeInOne {

    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    ThreeInOne(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    ;

    void push(StackIndex stackIndex, int value) {
        if (isFull(stackIndex.index)) {
            throw new FullStackException();
        }

        sizes[stackIndex.index]++;
        values[indexOfTop(stackIndex.index)] = value;
    }

    int pop(StackIndex stackIndex) {
        if (isEmpty(stackIndex)) {
            throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackIndex.index);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackIndex.index]--;
        return value;
    }

    int peek(StackIndex index) {
        if (isEmpty(index)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(index.index)];
    }

    boolean isEmpty(StackIndex stackIndex) {
        return sizes[stackIndex.index] == 0;
    }

    private boolean isFull(int stackIndex) {
        return sizes[stackIndex] == stackCapacity;
    }

    private int indexOfTop(int stackIndex) {
        int offset = stackIndex * stackCapacity;
        int size = sizes[stackIndex];
        return offset + size - 1;
    }

    enum StackIndex {
        A(0), B(1), C(2);

        private int index;

        StackIndex(int i) {
            index = i;
        }
    }

    class FullStackException extends RuntimeException { }

}
