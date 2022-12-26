import java.util.Arrays;

public class MinimumCostOfConstruction {
    static int parent[];
    static int rank[];

    static int find(int x) {
        if (parent[x] == x)
            return x;
        int res = find(parent[x]);
        parent[x] = res;
        return res;
    }

    static void union(int x, int y) {
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

    public static int solve(int n, int[][] grid) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        Arrays.sort(grid, (a, b) -> (a[2] - b[2]));
        int res = 0;
        for (int row[] : grid) {
            int pu = find(row[0]);
            int pv = find(row[1]);
            int wt = row[2];
            if (pu != pv) {
                union(pu, pv);
                res += wt;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int A = 3;
        int[][] B = { { 1, 2, 14 },
                { 2, 3, 7 },
                { 3, 1, 2 }, };
        int res = solve(A, B);
        System.out.println(res);
    }
}
