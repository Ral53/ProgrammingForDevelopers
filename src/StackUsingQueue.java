public class StackUsingQueue {
    CircularQueue q1 = new CircularQueue(5);
    CircularQueue q2 = new CircularQueue(5);

    void push(int data) {
        q2.enqueue(data);
        while(!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }
        CircularQueue temp = q1;
        q1 = q2;
        q2 = temp;
    }

    int pop() {
        return q1.dequeue();
    }
}
