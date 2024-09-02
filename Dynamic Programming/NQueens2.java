public class NQueens2{
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

    // Method to solve the N-Queens problem and print all solutions
    private static void solveNQueens(int[][] board, int row) {
        // Base case: If all queens are placed, print the solution
        if (row >= N) {
            printBoard(board);
            return;
        }

        // Try placing the queen in all columns one by one
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                // Place the queen
                board[row][col] = 1;

                // Recur to place the rest of the queens
                solveNQueens(board, row + 1);

                // If the queen placement doesn't lead to a solution
                // backtrack (remove the queen)
                board[row][col] = 0;
            }
        }
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
        solveNQueens(board, 0);
    }
}
