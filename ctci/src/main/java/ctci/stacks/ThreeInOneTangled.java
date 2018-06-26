package ctci.stacks;

import java.util.EmptyStackException;

/**
 * Three stack in one array
 */
class ThreeInOneTangled {

    int[] values;
    int[] indices = new int[]{0, 1, 2};

    ThreeInOneTangled(int length) {
        values = new int[length];
    }

    void push(int stackIndex, int value) {
        int index = indices[stackIndex - 1];
        if (index == values.length - 4 + stackIndex) {
            throw new RuntimeException("Stack-" + stackIndex + " is full");
        } else if (!isEmpty(1)) {
            index += 3;
        }
        values[index] = value;
        indices[stackIndex - 1] = index;
    }

    int pop(int stackIndex) {

        int index = indices[stackIndex - 1];
        int result = values[index];
        if (isEmpty(stackIndex)){
            throw new EmptyStackException();
        } else if (index != stackIndex-1){
            indices[stackIndex - 1] -= 3;
        }
        values[index] = 0;
        return result;
    }

    int peek(int stackIndex) {
        return values[indices[stackIndex-1]];
    }

    boolean isEmpty(int stackIndex) {
        int index = indices[stackIndex - 1];
        if (index == stackIndex-1) {
            return values[index] == 0;
        }
        return false;
    }
}
