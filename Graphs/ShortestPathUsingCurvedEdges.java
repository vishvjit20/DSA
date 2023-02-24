import java.util.*;

public class ShortestPathUsingCurvedEdges {
    static class Pair implements Comparable<Pair> {
        int vtx, dist;

        public Pair(int vtx, int dist) {
            this.vtx = vtx;
            this.dist = dist;
        }

        public int compareTo(Pair p) {
            return this.dist - p.dist;
        }
    }

    static int[] dijkstra(ArrayList<ArrayList<Pair>> adj, int src, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[n + 1];
        Arrays.fill(dist, 1000000007);
        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair rem = pq.remove();
            int u = rem.vtx;
            int d = rem.dist;
            if (dist[u] == d) {
                for (Pair nbr : adj.get(u)) {
                    int v = nbr.vtx;
                    int wt = nbr.dist;
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        return dist;
    }

    static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> curved = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w1 = edge.get(2);
            int w2 = edge.get(3);

            graph.get(u).add(new Pair(v, w1));
            graph.get(v).add(new Pair(u, w1));

            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(u);
            temp.add(v);
            temp.add(w2);

            curved.add(temp);
        }

        int distSrcA[] = dijkstra(graph, a, n);
        int distSrcB[] = dijkstra(graph, b, n);

        int res = distSrcA[b];
        for (int i = 0; i < m; i++) {
            int u = curved.get(i).get(0);
            int v = curved.get(i).get(1);
            int wt = curved.get(i).get(2);

            res = Math.min(res, wt + distSrcA[u] + distSrcB[v]);
            res = Math.min(res, wt + distSrcA[v] + distSrcB[u]);
        }

        if (res >= 1000000007) {
            return -1;
        }

        return res;
    }
}
