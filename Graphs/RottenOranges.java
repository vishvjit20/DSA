package Graphs;

import java.util.*;

public class RottenOranges {
    class Pair {
        int i, j, time;

        public Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        int freshOrangesCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    freshOrangesCount++;
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j, 0));
            }
        }

        int res = 0;
        int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            Pair rem = q.remove();
            res = rem.time;
            for (int k = 0; k < 4; k++) {
                int ni = rem.i + dirs[k][0];
                int nj = rem.j + dirs[k][1];

                if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == 1) {
                    q.add(new Pair(ni, nj, rem.time + 1));
                    grid[ni][nj] = 2;
                    freshOrangesCount--;
                }
            }
        }

        return freshOrangesCount == 0 ? res : -1;
    }
}
