import java.util.*;

public class PossibleBipartite {
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

    public boolean possibleBipartition(int n, int[][] dislikes) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        ArrayList<Integer> graph[] = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int row[] : dislikes) {
            int u = row[0], v = row[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (graph[i].size() == 0)
                continue;
            for (int nbr : graph[i]) {
                int curr = find(i);
                int nbr2 = find(nbr);
                if (curr == nbr2)
                    return false;
                union(graph[i].get(0), nbr);
            }
        }

        return true;

    }
}
