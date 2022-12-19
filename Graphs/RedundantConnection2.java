import java.util.Arrays;

public class RedundantConnection2 {
    int parent[];
    int rank[];

    int find(int x) {
        if (parent[x] == x)
            return x;
        int res = find(parent[x]);
        parent[x] = res;
        return res;
    }

    boolean union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx != ly) {
            if (rank[lx] > rank[ly])
                parent[ly] = lx;
            else if (rank[lx] < rank[ly])
                parent[lx] = ly;
            else {
                parent[lx] = ly;
                rank[ly]++;
            }
            return false;
        } else {
            return true;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        int inDeg[] = new int[n + 1];
        Arrays.fill(inDeg, -1);
        int bl1 = -1, bl2 = -1;
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (inDeg[v] == -1)
                inDeg[v] = i;
            else {
                bl1 = i;
                bl2 = inDeg[v];
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == bl1)
                continue;
            int u = edges[i][0];
            int v = edges[i][1];
            boolean flag = union(u, v);
            if (flag) {
                if (bl1 == -1)
                    return edges[i];
                else
                    return edges[bl2];
            }
        }

        return edges[bl1];
    }
}
