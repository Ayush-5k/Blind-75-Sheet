import java.util.*;
public class UniquePaths {
    public int help (int row, int col, int n, int m, int[][] dp) {

        if (row == n - 1 && col == m - 1) return 1;

        int[] delrow = {0, 1};
        int[] delcol = {1, 0};

        if (dp[row][col] != -1) return dp[row][col];

        int count = 0;

        for (int i = 0; i < 2; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                count += help (nrow, ncol, n, m, dp);
            }
        }
        return dp[row][col] = count;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return help (0, 0, m, n, dp);
    }
}
