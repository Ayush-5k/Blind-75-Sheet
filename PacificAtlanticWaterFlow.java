import java.util.*;
public class PacificAtlanticWaterFlow {
    public void dfs(int row, int col, int[][] heights, boolean[][] vis, int n, int m) {
        if (vis[row][col]) return;

        vis[row][col] = true;

        int[] delrow = {-1, 0, 0, 1};
        int[] delcol = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && heights[nrow][ncol] >= heights[row][col]) {
                dfs(nrow, ncol, heights, vis, n, m);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacificVis = new boolean[n][m];
        boolean[][] atlanticVis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(i, 0, heights, pacificVis, n, m);
            dfs(i, m - 1, heights, atlanticVis, n, m);
        }

        for (int j = 0; j < m; j++) {
            dfs(0, j, heights, pacificVis, n, m);
            dfs(n - 1, j, heights, atlanticVis, n, m);
        }

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacificVis[i][j] && atlanticVis[i][j]) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    arr.add(ans);
                }
            }
        }
        return arr;
    }
}
