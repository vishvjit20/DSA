import java.util.*;

public class DistanceOfNearestCell {
    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] solve(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int res[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                } else
                    res[i][j] = Integer.MAX_VALUE;
            }
        }

        int dirs[][] = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
        while (!q.isEmpty()) {
            Pair rem = q.remove();
            for (int k = 0; k < 4; k++) {
                int ni = rem.x + dirs[k][0];
                int nj = rem.y + dirs[k][1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                    if (res[ni][nj] > res[rem.x][rem.y]) {
                        res[ni][nj] = res[rem.x][rem.y] + 1;
                        q.add(new Pair(ni, nj));
                    }
                }
            }
        }
        return res;
    }
}
