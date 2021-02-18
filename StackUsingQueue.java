package queueDs;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args) {
        QueueStack queueStack = new QueueStack();
        queueStack.pop();
        queueStack.push(10);
        queueStack.push(20);
        queueStack.push(30);
        System.out.println(queueStack.top());
        System.out.println(queueStack.size());
        System.out.println(queueStack.pop());
        System.out.println(queueStack.top());
        System.out.println(queueStack.size());
    }
}

class QueueStack {
    Queue<Integer> stack, tempQueue;

    QueueStack() {
        stack = new ArrayDeque<>();
        tempQueue = new ArrayDeque<>();
    }

    int top() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty, no Top.");
            return -1;
        }
        return stack.peek();
    }

    void push(int data) {
        while (stack.peek() != null)
            tempQueue.offer(stack.poll());
        stack.offer(data);
        while (tempQueue.peek() != null)
            stack.offer(tempQueue.poll());

    }

    int pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty.");
            return -1;
        }
        return stack.poll();
    }

    int size() {
        return stack.size();
    }
}