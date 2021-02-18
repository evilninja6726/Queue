package queueDs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class InbuiltQueue {
    public static void main(String[] args) {
        // Queue<Integer> queue=new LinkedList<>(); We use LinkedList Implementation when we have large data because its worst time complexity is O(1).
        Queue<Integer> queue = new ArrayDeque<>(); //both are same but ArrayDeque is used in terms of cache friendliness and its time complexity is Amortized O(1).
        queue.offer(10); //same as enqueue()
        queue.offer(20);
        queue.offer(30);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue);
        System.out.println(queue.peek());  // gives the front
        System.out.println(queue.poll());   // same as dequeue
        System.out.println(queue);

    }
}
