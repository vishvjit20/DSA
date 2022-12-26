import java.util.*;

public class ShortestDistanceInAMaze {
    class Pair {
        int i, j, wt;

        public Pair(int i, int j, int wt) {
            this.i = i;
            this.j = j;
            this.wt = wt;
        }
    }

    public int solve(int[][] grid, int[] start, int[] end) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[start[0]][start[1]] == 1 || grid[end[0]][end[1]] == 1) {
            return -1;
        }

        Queue<Pair> q = new LinkedList<>();
        int dirs[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

        q.add(new Pair(start[0], start[1], 0));
        while (!q.isEmpty()) {
            Pair rem = q.remove();
            if (rem.i == end[0] && rem.j == end[1]) {
                return rem.wt;
            }
            for (int i = 0; i < 4; i++) {
                int ni = rem.i + dirs[i][0];
                int nj = rem.j + dirs[i][1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 0) {
                    grid[ni][nj] = 1;
                    q.add(new Pair(ni, nj, rem.wt + 1));
                }
            }
        }
        return -1;
    }
}
