public class SatisfiabilityOfEquations {
    int parent[];
    int rank[];

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
            if (rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if (rank[ly] > rank[lx]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
        }
    }

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (String exp : equations) {
            char c1 = exp.charAt(0);
            char c2 = exp.charAt(1);
            char c4 = exp.charAt(3);

            int lx = find(c1 - 'a');
            int ly = find(c4 - 'a');

            if (c2 == '=')
                union(lx, ly);
        }

        for (String exp : equations) {
            char c1 = exp.charAt(0);
            char c2 = exp.charAt(1);
            char c4 = exp.charAt(3);

            int lx = find(c1 - 'a');
            int ly = find(c4 - 'a');

            if (c2 == '!') {
                if (lx == ly) {
                    return false;
                }
            }
        }

        return true;
    }
}
