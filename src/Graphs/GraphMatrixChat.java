package Graphs;

public class GraphMatrix {

    private final int vertices;
    private final int[][] adjacencyMatrix;

    public GraphMatrix(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        // Add an edge from source to destination
        adjacencyMatrix[source][destination] = 1;
        // For undirected graph, also add an edge from destination to source
        adjacencyMatrix[destination][source] = 1;
    }

    public void display() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices A, B, C, D, E
        GraphMatrix graph = new GraphMatrix(vertices);

        graph.addEdge(0, 1); // A - B
        graph.addEdge(0, 2); // A - C
        graph.addEdge(1, 2); // B - C
        graph.addEdge(1, 3); // B - D
        graph.addEdge(2, 4); // C - E
        graph.addEdge(3, 4); // D - E

        graph.display();
    }
}
