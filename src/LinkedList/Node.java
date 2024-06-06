package LinkedList;

public class Node {
    public int data;
    public Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
