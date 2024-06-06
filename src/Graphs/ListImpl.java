package Graphs;

import LinkedList.Node;
import LinkedList.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class ListImpl {
    int vertices;
    SinglyLinkedList[] adjList;

    public ListImpl(int vertices) {
        this.vertices = vertices;
        adjList = new SinglyLinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new SinglyLinkedList();
        }
    }

    void addEdge(int source, int destination) {
        adjList[source].insertFirst(destination);
        adjList[destination].insertFirst(source);
    }

    void displayList() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to ");
            Node current = adjList[i].getHead();
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    List<Integer> getAdjNodes(int vertex) {
        List<Integer> list = new ArrayList<>();
        Node current = adjList[vertex].getHead();
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    public static void main(String[] args) {
        ListImpl graph = new ListImpl(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Adjacency List of the graph:");
        graph.displayList();

        int vertex = 1;
        List<Integer> adjNodes = graph.getAdjNodes(vertex);
        System.out.println("\nAdjacent nodes of vertex " + vertex + ": " + adjNodes);
    }
}
