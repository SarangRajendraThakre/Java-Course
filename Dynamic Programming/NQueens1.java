
public class NQueens1 {
    private static final int N = 8;

    // Method to check if the queen can be placed at board[row][col]
    private static boolean isSafe(int[][] board, int row, int col) {
        // Check this column on the upper side
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check the upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check the upper right diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Method to solve the N-Queens problem
    private static boolean solveNQueens(int[][] board, int row) {
        // Base case: If all queens are placed
        if (row >= N) {
            return true;
        }

        // Try placing the queen in all columns one by one
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                // Place the queen
                board[row][col] = 1;

                // Recur to place the rest of the queens
                if (solveNQueens(board, row + 1)) {
                    return true;
                }

                // If placing queen in board[row][col] doesn't lead to a solution
                // then remove the queen (backtrack)
                board[row][col] = 0;
            }
        }

        // If the queen cannot be placed in any column in this row, return false
        return false;
    }

    // Method to print the board
    private static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        if (solveNQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
