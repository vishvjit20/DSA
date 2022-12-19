public class RegionsCutBySlashes {
    int parent[];
    int rank[];
    int count;

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        int res = find(parent[x]);
        parent[x] = res;
        return res;
    }

    void union(int x, int y) {
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
        } else {
            count++;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int dots = n + 1;
        parent = new int[dots * dots];
        rank = new int[dots * dots];

        for (int i = 0; i < dots * dots; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        count = 1;
        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                if (i == 0 || i == n || j == 0 || j == n) {
                    int cellNo = i * dots + j;
                    if (cellNo != 0)
                        union(0, cellNo);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            char[] c = grid[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                if (c[j] == '/') {
                    int cell1 = i * dots + (j + 1);
                    int cell2 = (i + 1) * dots + j;
                    union(cell1, cell2);
                } else if (c[j] == '\\') {
                    int cell1 = i * dots + j;
                    int cell2 = (i + 1) * dots + (j + 1);
                    union(cell1, cell2);
                }
            }
        }

        return count;
    }
}
