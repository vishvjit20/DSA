public class BellmanFord {
    int[] bellman_ford(int n, int[][] edges, int src) {
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = 100000000;
        }
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], wt = edge[2];
                if (dist[u] != 100000000 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check negative cycle
        for (int edge[] : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            if (dist[u] != 100000000 && dist[u] + wt < dist[v]) {
                return new int[] { -1 };
            }
        }
        return dist;
    }
}
