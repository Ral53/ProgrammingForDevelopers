public class SinglyLinkedList {
    int size = 0;
    Node head = null;
    Node tail = null;

    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        }
//        else {
//            Node temp = head; // points out head.
//            while (temp.next != null) {
//                temp = temp.next;
//            } // while code to move between nodes. Move to desired code with null address.
//            temp.next = newNode; // then assign address of NewCode to temp ---CREATING a LINK---
//        }
        else {
            // Time  Complexity is O(n) but can it be reduced. We assign tail similar to head for storing
            // address of last item
            tail.next = newNode; // creates Link by storing next address in Last Node
            tail = newNode; // moves tail to now last Node
        }
        size++; // increase size of node bt each insertion.
    }

    void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null || tail == null) {
            head = tail = newNode;
        }else {
            newNode.next = head; // change
            head = newNode; // change head to make this insert First
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

}
