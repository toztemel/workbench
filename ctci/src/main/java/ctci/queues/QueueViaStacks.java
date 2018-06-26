package ctci.queues;

import java.util.Stack;

public class QueueViaStacks<Integer> {

    private Stack<Integer> newest;
    private Stack<Integer> oldest;

    QueueViaStacks() {
        newest = new Stack<>();
        oldest = new Stack<>();
    }

    void enqueue(Integer i) {
        newest.push(i);
    }

    Integer dequeue() {
        shiftStacks();
        return oldest.pop();
    }

    Integer peek() {
        shiftStacks();
        return oldest.peek();
    }

    private void shiftStacks() {
        if (oldest.isEmpty()) {
            while(!newest.isEmpty()) {
                oldest.push(newest.pop());
            }
        }
    }

}
