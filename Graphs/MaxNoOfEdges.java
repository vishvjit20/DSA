import java.util.*;

public class MaxNoOfEdges {
    static int find(int x, int parent[]) {
        if (parent[x] == x)
            return x;
        int res = find(parent[x], parent);
        parent[x] = res;
        return res;
    }

    public static boolean union(int x, int y, int parent[], int rank[]) {
        int lx = find(x, parent);
        int ly = find(y, parent);

        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }

            return false;
        } else {
            return true;
        }
    }

    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        int parentA[] = new int[n + 1];
        int parentB[] = new int[n + 1];
        int rankA[] = new int[n + 1];
        int rankB[] = new int[n + 1];

        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i <= n; i++) {
            parentA[i] = i;
            parentB[i] = i;
            rankA[i] = 1;
            rankB[i] = 1;
        }

        int removeE = 0;
        int mergedA = 1;
        int mergedB = 1;

        for (int edge[] : edges) {
            if (edge[0] == 3) {
                boolean tempA = union(edge[1], edge[2], parentA, rankA);
                boolean tempB = union(edge[1], edge[2], parentB, rankB);
                if (tempA)
                    mergedA++;
                if (tempB)
                    mergedB++;
                if (!tempA && !tempB)
                    removeE++;

            } else if (edge[0] == 1) {
                boolean tempA = union(edge[1], edge[2], parentA, rankA);
                if (tempA)
                    mergedA++;
                else
                    removeE++;
            } else {
                boolean tempB = union(edge[1], edge[2], parentB, rankB);
                if (tempB)
                    mergedB++;
                else
                    removeE++;
            }
        }

        if (mergedA != n || mergedB != n)
            return -1;
        return removeE;
    }

}
