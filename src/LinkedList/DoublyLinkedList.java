public class DoublyLinkedList {
    int size = 0;
    Node head = null;
    Node tail = null;

    void insertAtTail(int data) {
        Node tailNode = new Node(data);

        if (head == null || tail == null) {
            head = tail = tailNode;
        }
        else {
            // Time  Complexity is O(n) but can it be reduced. We assign tail similar to head for storing
            // address of last item
            tail.next = tailNode; // creates Link by storing next address in Last Node
            tailNode.prev = tail;
            tail = tailNode; // moves tail to now last Node
        }
        size++; // increase size of node bt each insertion.
    }

    void insertAtHead(int data) {
        Node headNode = new Node(data);
        if (head == null || tail == null) {
            head = tail = headNode;
        }else {
            headNode.next = head; // change
            head.prev = headNode;
            head = headNode; // change head to make this insert First
        }
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertDataAfter(Node node, int data) {
        Node currentNode = node;
        while(currentNode.next != null) {
            

        }
    }


}
