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

    public int[] solve(int n, int[][] grid) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        Arrays.sort(grid, (a, b) -> a[2] - b[2]);
        int[] res = new int[grid.length];
        int idx = -1, pw = -1;
        for (int i = 0; i < grid.length; i++) {
            int u = grid[0][0], v = grid[0][1];
            ++idx;
            if (pw == grid[0][2])
                continue;
            int pu = find(u);
            int pv = find(v);
            if (pu != pv) {
                res[idx] = 1;
                union(pu, pv);
                pw = grid[0][2];
            }
        }

        return res;
    }
}
