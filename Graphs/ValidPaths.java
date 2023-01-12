public class ValidPaths {
    boolean flag = false;

    void dfs(int x1, int y1, int x2, int y2, boolean visited[][]) {
        if (x1 < 0 || y1 < 0 || x1 >= visited.length || y1 >= visited[0].length || visited[x1][y1])
            return;
        if (x1 == x2 && y1 == y2) {
            flag = true;
            return;
        }

        visited[x1][y1] = true;

        dfs(x1 - 1, y1 - 1, x2, y2, visited);
        dfs(x1 - 1, y1 + 1, x2, y2, visited);
        dfs(x1 + 1, y1 - 1, x2, y2, visited);
        dfs(x1 + 1, y1 + 1, x2, y2, visited);
        dfs(x1 - 1, y1, x2, y2, visited);
        dfs(x1 + 1, y1, x2, y2, visited);
        dfs(x1, y1 - 1, x2, y2, visited);
        dfs(x1, y1 + 1, x2, y2, visited);
    }

    public String solve(int x, int y, int noOfCircles, int radius, int[] E, int[] F) {
        boolean[][] visited = new boolean[x + 1][y + 1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k < noOfCircles; k++) {

                    int dist = (i - E[k]) * (i - E[k]) + (j - F[k]) * (j - F[k]);
                    if (dist <= radius * radius) {
                        visited[i][j] = true;
                        break;
                    }
                }
            }
        }

        if (visited[x][y] || visited[0][0]) {
            return "NO";
        }

        dfs(0, 0, x, y, visited);
        return flag ? "YES" : "NO";
    }
}
