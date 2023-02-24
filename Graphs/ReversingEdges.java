import java.util.*;

public class ReversingEdges {
    class Pair {
        int vtx, wt;

        public Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }
    }

    public int reverseEdges(int n, int[][] grid) {
        List<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int row[] : grid) {
            int u = row[0], v = row[1];
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
            if (rem.vtx == n - 1)
                return rem.wt;
            for (Pair nbr : graph[rem.vtx]) {
                if (!visited[rem.vtx]) {
                    if (nbr.wt == 0) {
                        q.addFirst(new Pair(nbr.vtx, rem.wt + nbr.wt));
                    } else {
                        q.add(new Pair(nbr.vtx, rem.wt + nbr.wt));
                    }
                }
            }
        }

        return -1;
    }
}
