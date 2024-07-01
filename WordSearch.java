public class WordSearch {
    public boolean dfs(int row, int col, char[][] board, String word, int ind, boolean[][] visited) {
        if (ind == word.length()) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || visited[row][col] || board[row][col] != word.charAt(ind)) {
            return false;
        }

        visited[row][col] = true;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};

        for (int d = 0; d < 4; d++) {
            int nrow = row + delrow[d];
            int ncol = col + delcol[d];

            if (dfs(nrow, ncol, board, word, ind + 1, visited)) {
                return true;
            }
        }

        visited[row][col] = false;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                boolean[][] visited = new boolean[m][n];

                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
