package Queue;

public class Queues {

    int[] queue;
    int front = -1;
    int rear = -1;
    int size;

    public Queues(int size) {
        this.size = size;
        queue = new int[size];
    }

    boolean isFull() {
        return rear == size - 1;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full.");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = rear + 1;
            queue[rear] = data;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return -1;
        }
        if(front == rear) {
            int temp = queue[front];
            front = -1;
            return queue[temp];
        }
        return queue[front++];
    }

}
