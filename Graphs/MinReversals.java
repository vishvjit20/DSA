import java.util.*;

public class MinReversals {
    static class Pair {
        int vtx, wt;

        public Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }
    }

    public static int reverseEdges(int n, int[][] grid) {
        ArrayList<Pair> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int row[] : grid) {
            int u = row[0] - 1, v = row[1] - 1;
            graph[u].add(new Pair(v, 0));
            graph[v].add(new Pair(u, 1));
        }
        boolean visited[] = new boolean[n];

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair rem = q.remove();
            if (visited[rem.vtx])
                continue;
            visited[rem.vtx] = true;
            if (rem.vtx == n - 1) {
                return rem.wt;
            }

            for (Pair nbrs : graph[rem.vtx]) {
                if (!visited[nbrs.vtx]) {
                    if (nbrs.wt == 0)
                        q.addFirst(new Pair(nbrs.vtx, nbrs.wt + rem.wt));
                    else
                        q.addLast(new Pair(nbrs.vtx, nbrs.wt + rem.wt));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int A = 10;
        int[][] B = {
                { 1, 2 },
                { 1, 2 },
                { 2, 3 },
                { 2, 3 },
                { 5, 2 },
                { 5, 2 },
                { 2, 4 },
                { 2, 1 },
                { 1, 7 },
                { 1, 9 },
                { 5, 3 },
                { 3, 6 },
                { 1, 5 },
                { 4, 6 },
                { 2, 4 },
                { 10, 8 },
                { 9, 8 },
                { 8, 9 },
                { 10, 9 },
                { 10, 4 },
        };

        int res = reverseEdges(A, B);
        System.out.println(res);
    }
}
