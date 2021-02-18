package queueDs;

public class QueueUsingArray {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(4);
        System.out.println(arrayQueue.isEmpty());
        System.out.println(arrayQueue.isFull());
        System.out.println(arrayQueue.getFront());
        System.out.println(arrayQueue.getRear());
        arrayQueue.dequeue();

        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        System.out.println(arrayQueue.getFront());
        System.out.println(arrayQueue.getRear());
        System.out.println(arrayQueue.dequeue());
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        System.out.println(arrayQueue.size());
        arrayQueue.enqueue(60);
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        System.out.println(arrayQueue.getFront() + " " + arrayQueue.getRear());

        System.out.println();


        QueueUsingArrayEff queueUsingArrayEff = new QueueUsingArrayEff(4);
//        queueUsingArrayEff.dequeue();
//        queueUsingArrayEff.enqueue(10);
//        queueUsingArrayEff.enqueue(20);
//        queueUsingArrayEff.enqueue(30);
//        System.out.println(queueUsingArrayEff.dequeue());
//        System.out.println(queueUsingArrayEff.dequeue());

        System.out.println();

        System.out.println(queueUsingArrayEff.isEmpty());
        System.out.println(queueUsingArrayEff.isFull());
        System.out.println(queueUsingArrayEff.getFront());
        System.out.println(queueUsingArrayEff.getRear());
        queueUsingArrayEff.dequeue();

        queueUsingArrayEff.enqueue(10);
        queueUsingArrayEff.enqueue(20);
        queueUsingArrayEff.enqueue(30);
        System.out.println(queueUsingArrayEff.getFront());
        System.out.println(queueUsingArrayEff.getRear());
        System.out.println(queueUsingArrayEff.dequeue());
        System.out.println(queueUsingArrayEff.getFront());
        queueUsingArrayEff.enqueue(40);
        queueUsingArrayEff.enqueue(50);

        System.out.println(queueUsingArrayEff.size());
        System.out.println(queueUsingArrayEff.getFront());
        System.out.println(queueUsingArrayEff.getRear());
        queueUsingArrayEff.enqueue(60);
        System.out.println(queueUsingArrayEff.getFront());
        System.out.println(queueUsingArrayEff.getRear());
        queueUsingArrayEff.dequeue();
        queueUsingArrayEff.dequeue();
        System.out.println(queueUsingArrayEff.getFront() + " " + queueUsingArrayEff.getRear());
    }
}

class ArrayQueue {
    private int capacity, size, front, rear;
    private int[] arr;

    ArrayQueue(int capacity) {
        this.capacity = capacity;
        size = 0;
        front = 0;
        rear = -1;
        arr = new int[capacity];
    }

    void enqueue(int data) {
        if (rear == capacity - 1) {
            System.out.println("Queue if Full.");
            return;
        } else {
            arr[++rear] = data;
            size++;
        }
    }

    int dequeue() {
        if (rear == -1) {
            System.out.println("Queue is Empty.");
            return -1;
        } else {
            int x = arr[front];
            for (int i = 0; i < rear; i++)
                arr[i] = arr[i + 1];
            rear--;
            size--;
            return x;
        }
    }

    int size() {
        return size;
    }

    int getFront() {
        if (rear == -1) {
            System.out.println("No Front, Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    int getRear() {
        if (rear == -1) {
            System.out.println("No Rear, Queue is Empty");
            return -1;
        }
        return arr[rear];
    }

    boolean isFull() {
        if (size == capacity)
            return true;
        return false;
    }

    boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }
}

class QueueUsingArrayEff {
    int capacity, rear, front, size;
    int[] arr;

    QueueUsingArrayEff(int capacity) {
        this.capacity = capacity;
        rear = -1;
        front = -1;
        size = 0;
        arr = new int[capacity];
    }

    void enqueue(int data) {
        if (front == -1) {
            arr[++front] = data;
            rear++;
            size++;
        } else {
            arr[(rear + 1) % capacity] = data;
            rear = (rear + 1) % capacity;
            if (rear == front)
                front = (front + 1) % capacity;
            size++;
        }
    }

    int dequeue() {
        if (rear == -1) {
            System.out.println("Queue is Empty.");
            return -1;
        }
        int x = arr[(front) % capacity];
        front = (front + 1) % capacity;
        size--;
        return x;
    }

    int getFront() {
        if (front == -1) {
            System.out.println("No Front, Queue is Empty.");
            return -1;
        }
        return arr[front % capacity];
    }

    int getRear() {
        if (rear == -1) {
            System.out.println("No Rear, Queue is Empty.");
            return -1;
        }
        return arr[rear % capacity];
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }
}
