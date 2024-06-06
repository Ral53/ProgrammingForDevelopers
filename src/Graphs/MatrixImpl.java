package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MatrixImpl {
    int vertices;
    int[][] matrix;

    MatrixImpl(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
        matrix[destination][source] = weight;
    }

    void displayGraph() {
        for(int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to ");
            for(int j = 0; j < vertices; j++) {
                if(matrix[i][j] != 0) {
                    System.out.print(j + "(" + matrix[i][j] + ") ");
                }
            }
            System.out.println();
        }
    }

    List<Integer> getAdjacentNode(int i) {
        List<Integer> list = new ArrayList<>();
        for(int j = 0; j < vertices; j++) {
            if(matrix[i][j] != 0) {
                list.add(j);
            }
        }
        return list;
    }

    void breadthFirstSearch(int source) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        visited[source] = true;
        queue.add(source);

        while(!queue.isEmpty()) {
            int u = queue.poll();

            for (int j = 0; j < vertices; j++) {
                if (matrix[u][j] != 0 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    void dfs(boolean[] visited, int source) {
        visited[source] = true;
        System.out.println(source);
        for (int j = 0; j < vertices; j++) {
            if (matrix[source][j] != 0 && !visited[j]) {
                dfs(visited, j);
            }
        }
    }

    void depthFirstSearch(int source) {
        boolean[] visited = new boolean[vertices];
        dfs(visited, source);
    }

    int shortestPath(int source, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        int[] dist = new int[vertices];
        int[] prevPath = new int[vertices];

        // Initialize distances and previous path array
        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            prevPath[i] = -1;
        }

        dist[source] = 0;
        visited[source] = true;
        queue.add(source);

        // BFS to find the shortest path
        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int j = 0; j < vertices; j++) {
                if (matrix[u][j] != 0 && !visited[j]) {
                    if (dist[u] + 1 < dist[j]) {
                        dist[j] = dist[u] + 1;
                        prevPath[j] = u;
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
        }

        // Reconstruct the shortest path using a stack
        if (dist[destination] == Integer.MAX_VALUE) {
            System.out.println("No path found from " + source + " to " + destination);
            return -1; // Return -1 if no path exists
        }

        Stack<Integer> shortPath = new Stack<>();
        for (int at = destination; at != -1; at = prevPath[at]) {
            shortPath.push(at);
        }

        // Print the path
        System.out.println("Printing Path : ");
        while (!shortPath.isEmpty()) {
            System.out.print(shortPath.pop() + " ");
        }
        System.out.println();

        // Return the distance to the destination
        return dist[destination];
    }

    int dijakStra(int source, int destination) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];
        int[] prevPath = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            prevPath[i] = -1;
        }
        dist[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int u = findMinVertex(visited, dist);
            visited[u] = true;

            for (int j = 0; j < vertices; j++) {
                if (matrix[u][j] != 0 && !visited[j] && dist[u] + matrix[u][j] < dist[j]) {
                    dist[j] = dist[u] + matrix[u][j];
                    prevPath[j] = u;
                }
            }
        }

        // Reconstruct the shortest path using a stack
        if (dist[destination] == Integer.MAX_VALUE) {
            System.out.println("No path found from " + source + " to " + destination);
            return -1; // Return -1 if no path exists
        }

        Stack<Integer> shortPath = new Stack<>();
        for (int at = destination; at != -1; at = prevPath[at]) {
            shortPath.push(at);
        }

        // Print the path
        System.out.println("Printing Path : ");
        while (!shortPath.isEmpty()) {
            System.out.print(shortPath.pop() + " ");
        }
        System.out.println();

        // Return the distance to the destination
        return dist[destination];
    }

    int findMinVertex(boolean[] visited, int[] dist) {
        int minVertex = -1;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && (minVertex == -1 || dist[i] < dist[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        MatrixImpl graph = new MatrixImpl(6);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 5, 20);
        graph.addEdge(1, 3, 5);
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 5, 3);
        graph.addEdge(4, 5, 2);
        graph.displayGraph();

        int distance = graph.dijakStra(0, 5);
        if (distance != -1) {
            System.out.println("Shortest Path distance using Dijkstra: " + distance);
        }
    }
}
