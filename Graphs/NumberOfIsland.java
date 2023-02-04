public class NumberOfIsland {
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i - 1, j - 1);
        dfs(grid, i + 1, j + 1);
        dfs(grid, i - 1, j + 1);
        dfs(grid, i + 1, j - 1);

    }
}
