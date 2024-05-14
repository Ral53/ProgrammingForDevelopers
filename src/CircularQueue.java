public class CircularQueue {
    int[] queue;
    int front, rear = -1;
    int size;

    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    boolean isFull() {
        return (rear + 1) % size == front;
    }

    boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full.");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            queue[rear] = data;
        }
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return -1;
        }
        if (front == rear) {
            int temp = queue[front];
            front = rear - 1;
            return queue[temp];
        }
        int temp = queue[front];
        front = (front + 1)  % size;
        return queue[temp];
    }
}
