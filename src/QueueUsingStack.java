import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    void enqueue(int item) {
        s1.push(item);
        System.out.println("Enqueued " + item);
    }

    int dequeue() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int poppedElement = s2.pop();
        System.out.println("Popped element: " + poppedElement);
        return poppedElement;
    }
}
