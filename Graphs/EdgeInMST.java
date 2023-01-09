import java.util.*;

public class EdgeInMST {
    int parent[];
    int rank[];

    int find(int x) {
        if (parent[x] == x)
            return x;
        int res = find(parent[x]);
        parent[x] = res;
        return res;
    }

    void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);
        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
        }
    }

    class Pair {
        int x, y, wt, idx;

        public Pair(int x, int y, int wt, int idx) {
            this.x = x;
            this.y = y;
            this.wt = wt;
            this.idx = idx;
        }
    }

    public int[] solve(int n, int[][] grid) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        Pair[] pairs = new Pair[grid.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(grid[i][0], grid[i][1], grid[i][2], i);
        }
        Arrays.sort(pairs, (a, b) -> a.wt - b.wt);
        int[] res = new int[grid.length];
        int i = 0, j = 0;
        while (i < grid.length) {
            j = i;
            while (j < grid.length && pairs[i].wt == pairs[j].wt) {
                int u = pairs[j].x, v = pairs[j].y;
                int pu = find(u);
                int pv = find(v);
                if (pu != pv) {
                    res[pairs[j].idx] = 1;
                }
                j++;
            }
            j = i;
            while (j < grid.length && pairs[i].wt == pairs[j].wt) {
                int u = pairs[j].x, v = pairs[j].y;
                int pu = find(u);
                int pv = find(v);
                if (pu != pv) {
                    union(pu, pv);
                }
                j++;
            }
            i = j;
        }

        return res;
    }
}
