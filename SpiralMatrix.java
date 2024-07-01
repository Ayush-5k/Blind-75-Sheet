import java.util.*;
public class SpiralMatrix {
    public void help(int row, int col, int[][] matrix, String direction, List<Integer> ans, int n, int m, boolean[][] vis) {
        if (ans.size() == n * m) return;

        if (direction.equals("down")) {
            while (row < n && !vis[row][col]) {
                ans.add(matrix[row][col]);
                vis[row][col] = true;
                row++;
            }
            row--; // Adjust row to the last valid position
            help(row, col - 1, matrix, "left", ans, n, m, vis); // Adjust col before next call
        } else if (direction.equals("left")) {
            while (col >= 0 && !vis[row][col]) {
                ans.add(matrix[row][col]);
                vis[row][col] = true;
                col--;
            }
            col++;
            help(row - 1, col, matrix, "up", ans, n, m, vis);
        } else if (direction.equals("right")) {
            while (col < m && !vis[row][col]) {
                ans.add(matrix[row][col]);
                vis[row][col] = true;
                col++;
            }
            col--;
            help(row + 1, col, matrix, "down", ans, n, m, vis);
        } else { // direction.equals("up")
            while (row >= 0 && !vis[row][col]) {
                ans.add(matrix[row][col]);
                vis[row][col] = true;
                row--;
            }
            row++;
            help(row, col + 1, matrix, "right", ans, n, m, vis);
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        help(0, 0, matrix, "right", ans, n, m, new boolean[n][m]);
        return ans;
    }
}
