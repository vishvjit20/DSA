public class RedundantConnection {
    int parent[];
    int rank[];

    int find(int x) {
        if (parent[x] == x)
            return x;
        int res = find(parent[x]);
        parent[x] = res;
        return res;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int edge[] : edges) {
            int u = edge[0], v = edge[1];
            int lu = find(u);
            int lv = find(v);
            if (lu != lv) {
                if (rank[lu] > rank[lv]) {
                    parent[lv] = lu;
                } else if (rank[lu] < rank[lv]) {
                    parent[lu] = lv;
                }

                else {
                    parent[lu] = lv;
                    rank[lv]++;
                }

            } else {
                return edge;
            }
        }

        return new int[2];
    }
}
