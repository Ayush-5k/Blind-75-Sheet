public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        boolean[][] vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = temp;
                    vis[i][j] = true;
                    vis[j][n - i - 1] = true;
                }

            }
        }
    }
}
