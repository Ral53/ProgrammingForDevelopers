package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    boolean isSafe(Character board[][], int row, int col) {
        // j = column
        for(int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        // i = row
        for(int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        int i, j;
        // for diagonal upward left
        for (i = row, j = col; i >= 0 && j >=0; i--, j--) {
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        // for diagonal downward right
        for (i = row, j = col; i < board.length && j < board.length; i++, j++) {
            if (board[i][j] == 'Q'){
                return false;
            }
        }

        // for diagonal upward right
        for (i = row, j = col; i >=0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        // for diagonal downward left
        for (i = row, j = col; i < board.length && j >=0; i++, j--) {
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    void NQueenHelper(Character[][] board, List<List<String>> allSoln, int col) {
        if (col == board.length) {
            // Save the solution to allSoln list
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    row.append(board[i][j]);
                }
                solution.add(row.toString());
            }
            allSoln.add(solution);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                NQueenHelper(board, allSoln, col + 1);
                board[row][col] = '-';
            }
        }
    }

    public static void main(String[] args) {
        int n = 4; // Size of the chess board (4x4 in this case)
        Character board[][] = new Character[n][n];

        // Initialize the board with empty spaces ('.')
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '-';
            }
        }

        List<List<String>> allSoln = new ArrayList<>();

        NQueenProblem q = new NQueenProblem();
        q.NQueenHelper(board, allSoln, 0);

        // Print all solutions
        for (List<String> solution : allSoln) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

}
