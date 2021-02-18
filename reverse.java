package queueDs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class reverse {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(10); //same as enqueue()
        queue.offer(20);
        queue.offer(30);
        System.out.println(reverse(queue));
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        reverseRec(q);
        System.out.println(q);
    }

    public static Queue<Integer> reverse(Queue<Integer> q) {
        if (q.peek() == null)
            return null;
        Stack<Integer> stack = new Stack<>();
        while (q.peek() != null)
            stack.push(q.poll());
        while (!stack.isEmpty())
            q.offer(stack.pop());
        return q;
    }

    public static void reverseRec(Queue<Integer> q) {
        if (q.peek() == null)
            return;
        int front = q.poll();
        reverseRec(q);
        q.offer(front);
    }
}
