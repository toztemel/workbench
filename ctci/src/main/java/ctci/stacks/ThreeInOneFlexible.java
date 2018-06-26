package ctci.stacks;

import java.util.EmptyStackException;

/**
 * Three stack in one array
 * <ul>
 * circular growth
 * shifts elements to allocate more space
 * </ul>
 */
public class ThreeInOneFlexible {

    private int[] values;
    private StackInfo[] info;

    ThreeInOneFlexible(int numberOfStacks, int defaultSize) {
        info = new StackInfo[numberOfStacks];
        for (int i = 0; i < numberOfStacks; i++) {
            info[i] = new StackInfo(defaultSize * i, defaultSize);
        }
        values = new int[numberOfStacks * defaultSize];
    }

    void push(StackIndex stackIndex, int value) {
        int stackNum = stackIndex.index;

        if (allStacksAreFull()) {
            throw new FullStackException();
        }

        StackInfo stack = info[stackNum];
        if (stack.isFull()) {
            expand(stackNum);
        }

        stack.size++;
        values[stack.lastElementIndex()] = value;
    }

    int pop(StackIndex stackIndex) {
        int stackNum = stackIndex.index;
        StackInfo stack = info[stackNum];
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        int value = values[stack.lastElementIndex()];
        values[stack.lastElementIndex()] = 0;
        stack.size--;
        return value;
    }

    int peek(StackIndex index) {
        int stackNum = index.index;
        StackInfo stack = info[stackNum];
        return values[stack.lastElementIndex()];
    }

    // expand stack by one, shift others
    private void expand(int stackNum) {
        shift((stackNum + 1) % info.length);
        info[stackNum].capacity++;
    }

    // if capacity is available,
    private void shift(int stackNum) {
        System.out.println("/// Shifting" + stackNum);
        StackInfo stack = info[stackNum];
        if (stack.size >= stack.capacity) {
            int nextStack = (stackNum + 1) % info.length;
            shift(nextStack);
            stack.capacity++;
        }

        int index = stack.lastCapacityIndex();
        while (stack.isWithinStackCapacity(index)) {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }
        values[stack.start] = 0;
        stack.start = nextIndex(stack.start);
        stack.capacity--;
    }

    // # of items in stack
    private int numberOfElements() {
        int size = 0;
        for (StackInfo sd : info) {
            size += sd.size;
        }
        return size;
    }


    boolean allStacksAreFull() {
        return numberOfElements() == values.length;
    }

    /**
     * move forwards in circular index
     */
    private int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    /**
     * move backwards in circular index
     */
    private int previousIndex(int index) {
        return adjustIndex(index - 1);
    }

    private int adjustIndex(int index) {
        // (-11 % 5) is -1 , not 4
        int max = values.length;
        return ((index % max) + max) % max;
    }

    enum StackIndex {
        A(0), B(1), C(2);

        private int index;

        StackIndex(int i) {
            index = i;
        }
    }

    private class StackInfo {

        private int start;
        private int size;
        private int capacity;

        StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        boolean isWithinStackCapacity(int index) {
            if (index < 0 || index >= values.length) {
                return false;
            }
            int contiguousIndex = index < start ?
                    index + values.length : index;
            int end = start + capacity;
            return start <= contiguousIndex && contiguousIndex < end;
        }

        public int lastCapacityIndex() {
            return adjustIndex(start + capacity - 1);
        }

        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }

        public boolean isFull() {
            return size == capacity;
        }


        public boolean isEmpty() {
            return size == 0;
        }

    }

    class FullStackException extends RuntimeException {
    }

}
