package queueDs;

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        System.out.println(linkedListQueue.getFront());
        System.out.println(linkedListQueue.getRear());
        linkedListQueue.dequeue();
        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(20);
        linkedListQueue.enqueue(30);
        linkedListQueue.enqueue(40);
        linkedListQueue.enqueue(50);
        System.out.println(linkedListQueue.getSize());
        System.out.println(linkedListQueue.getRear() + " " + linkedListQueue.getFront());
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.getRear() + " " + linkedListQueue.getFront());

    }
}

class LinkedListQueue {
    Node front;
    Node rear;
    int size;

    LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    void enqueue(int data) {
        Node firstNode = new Node(data);
        if (front == null) {
            front = firstNode;
            rear = firstNode;
        } else {
            rear.next = firstNode;
            rear = firstNode;
        }
        size++;
    }

    int getFront() {
        if (front == null) {
            System.out.println("No Front, Queue is Empty");
            return -1;
        }
        size--;
        return front.data;
    }

    int getRear() {
        if (rear == null) {
            System.out.println("No Rear, Queue is Empty");
            return -1;
        }
        return rear.data;
    }

    int dequeue() {
        if (rear == null) {
            System.out.println("Can't Dequeue, Queue is already Empty.");
            return -1;
        }
        Node x = new Node(front.data);
        front = front.next;
        return x.data;
    }

    boolean isEmpty() {
        return front == null;
    }

    int getSize() {
        return size;
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}