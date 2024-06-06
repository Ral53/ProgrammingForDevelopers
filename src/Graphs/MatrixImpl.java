package Graphs;

public class GraphMatrixImpl {
    int vertices;
    int[][] matrix;

    GraphMatrixImpl(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdge(int source, int destination) {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }

    void displayGraph() {
        for(int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to ");
            for(int j = 0; j < vertices; j++) {
                if(matrix[i][j] != 0) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphMatrixImpl graph = new GraphMatrixImpl(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        graph.displayGraph();
    }
}

