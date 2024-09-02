
import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        int n = 8;
        List<int[]> solutions = new ArrayList<>();
        int[] board = new int[n];
        solveNQueens(0, n, board, solutions);
        System.out.println("Number of solutions: " + solutions.size());
    }

    private static boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private static void solveNQueens(int row, int n, int[] board, List<int[]> solutions) {
        if (row == n) {
            solutions.add(board.clone());
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col;
                solveNQueens(row + 1, n, board, solutions);
            }
        }
    }
}
