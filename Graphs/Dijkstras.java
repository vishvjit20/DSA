import java.util.*;

public class Dijkstras {
    static class Pair implements Comparable<Pair> {
        int vtx, wt;

        public Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }

        public int compareTo(Pair p) {
            return this.wt - p.wt;
        }
    }

    public static int[] solve(int n, int[][] grid, int src) {
        ArrayList<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int row[] : grid) {
            int u = row[0], v = row[1], wt = row[2];
            graph[u].add(new Pair(v, wt));
            graph[v].add(new Pair(u, wt));
        }

        // for (int i = 0; i < n; i++) {
        // System.out.print(i + " -> ");
        // for (int j = 0; j < graph[i].size(); j++) {
        // System.out.print("(" + graph[i].get(j).vtx + ", " + graph[i].get(j).wt + "),
        // ");
        // }
        // System.out.println();
        // }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair rem = pq.remove();
            int u = rem.vtx;
            int d = rem.wt;

            if (dist[u] == d) {
                for (Pair p : graph[u]) {
                    int v = p.vtx;
                    int wt = p.wt;
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;

    }

    public static void main(String[] args) {
        int A = 6;
        int[][] B = {
                { 0, 4, 9 },
                { 3, 4, 6 },
                { 1, 2, 1 },
                { 2, 5, 1 },
                { 2, 4, 5 },
                { 0, 3, 7 },
                { 0, 1, 1 },
                { 4, 5, 7 },
                { 0, 5, 1 },
        };
        int C = 4;

        int[] res = solve(A, B, C);
        System.out.println(Arrays.toString(res));
    }
}
