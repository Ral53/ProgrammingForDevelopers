import Caching.LruCaching;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

//        Stacks stack = new Stacks(5);
//        stack.push('b');
//        stack.push('b');
//        System.out.println("Last element of Stack : " + stack.pop());
//
//        String input = "{{()}";
//        boolean valid = ("{" == "}");
//        System.out.println(valid);

// ======================================================================================================

////        Statement for "CheckParentheses" Class
//        CheckParentheses chk = new CheckParentheses();
//        System.out.println(chk.isValid("{()}"));  // Should print true
//        System.out.println(chk.isValid("{(})"));  // Should print false
//        System.out.println(chk.isValid("{([)]}")); // Should print false
//        System.out.println(chk.isValid("{[]}()")); // Should print true

// ======================================================================================================

//        // Create an instance of the InfixToPostFix class
//        InfixToPostFix converter = new InfixToPostFix();
//        // Example infix expression
//        String infixExpression1 = "3 + 4 * 2 / (1 - 5)^2";
//        // Convert the infix expression to postfix
//        String postfixExpression = converter.convertPostFix(infixExpression1);
//        // Print the postfix expression
//        System.out.println("Postfix expression: " + postfixExpression);

// ======================================================================================================

//        // Infix to Prefix Conversion Example
//        String infixExpression = "K+L-M*N+(O^P)*W/U/V*T+Q"; // Given infix expression
//        InfixToPrefix.infixToPrefix(infixExpression);


// ======================================================================================================

//        // Main method to test the postfixToInfix function
//        String postfixExpression = "2 3 + 4 *";
//        // Convert the postfix expression to infix
//        String infixExpression = PostfixToInfix.postfixToInfix(postfixExpression);
//        // Print the original postfix expression and the resulting infix expression
//        System.out.println("Postfix expression: " + postfixExpression);
//        System.out.println("Infix expression: " + infixExpression);

// ======================================================================================================

//        // Main method to test the prefixToInfix function
//        String prefixExpression = "*+23-45";
//        // Convert the prefix expression to infix
//        String infixExpression = PrefixToInfix.prefixToInfix(prefixExpression);
//        // Print the original prefix expression and the resulting infix expression
//        System.out.println("Prefix expression: " + prefixExpression);
//        System.out.println("Infix expression: " + infixExpression);

// ======================================================================================================
        // Create a queue with a size of 5
//        Queues queue = new Queues(5);
//
//        // Enqueue some elements
//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);
//        queue.enqueue(40);
//        queue.enqueue(50);

        // Try to enqueue when the queue is full
//        queue.enqueue(60); // Should print "Queue is Full"
//
//        // Dequeue elements
//        System.out.println(queue.dequeue()); // Should print 10
//        System.out.println(queue.dequeue()); // Should print 20
//        System.out.println(queue.dequeue()); // Should print 30
//
//        // Enqueue more elements
//        queue.enqueue(60);
//        queue.enqueue(70);
//
//        // Dequeue remaining elements
//        System.out.println(queue.dequeue()); // Should print 40
//        System.out.println(queue.dequeue()); // Should print 50
//        System.out.println(queue.dequeue()); // Should print 60
//        System.out.println(queue.dequeue()); // Should print 70
//
//        // Try to dequeue when the queue is empty
//        System.out.println(queue.dequeue()); // Should print "Queue is Empty"

// ======================================================================================================

//// Create a new instance of the QueueUsingStack class
//        QueueUsingStack queue = new QueueUsingStack();
//
//// Enqueue elements into the queue
//        queue.enqueue(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//
//// Print a message indicating that elements are being dequeued
//        System.out.println("Dequeuing elements:");
//
//// Dequeue elements from the queue
//        queue.dequeue(); // Dequeue the first element (1)
//        queue.dequeue(); // Dequeue the second element (2)
//        queue.dequeue(); // Dequeue the third element (3)

// ======================================================================================================

//        // Linked List Implementation
//        SinglyLinkedList list = new SinglyLinkedList();
//        list.insert(1);
//        list.insert(2);
//        list.insert(3);
//        list.insert(4);
//        list.insert(5);
//
//        System.out.println("Singly Linked List:");
//        list.display();

// ======================================================================================================
//
//        DoublyLinkedList list = new DoublyLinkedList();
//
//        // Inserting elements at the tail
//        list.insertAtTail(1);
//        list.insertAtTail(2);
//        list.insertAtTail(3);
//
////        // Displaying the list
////        System.out.println("Doubly Linked List:");
////        list.display(); // Output: 1 2 3
//
//        // Inserting elements at the head
//        list.insertAtHead(0);
//        list.insertAtHead(-1);
//
//        // Displaying the list after inserting at the head
//        System.out.println("Doubly Linked List after inserting at the head:");
//        list.display(); // Output: -1 0 1 2 3


// ======================================================================================================

//// Create an LRU cache with capacity 3
//        LruCaching cache = new LruCaching(3);
//
//        // Insert some key-value pairs into the cache
//        cache.put(1, 10);
//        cache.put(2, 20);
//        cache.put(3, 30);
//
//        // Retrieve values from the cache
//        System.out.println(cache.get(1)); // Output: 10
//        System.out.println(cache.get(2)); // Output: 20
//        System.out.println(cache.get(3)); // Output: 30
////
//        // Add a new key-value pair, which should evict the least recently used item (key=1)
//        cache.put(4, 40);
//
//        // Retrieve values from the cache
//        System.out.println(cache.get(1)); // Output: 10
//        System.out.println(cache.get(2)); // Output: 20
//        System.out.println(cache.get(3)); // Output: 30
//
////        // The value associated with key=1 should no longer be in the cache
////        System.out.println(cache.get(1)); // Output: -1 (key not found)

// ======================================================================================================



       }

}
