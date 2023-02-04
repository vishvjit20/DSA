import java.util.*;

public class PathInDirectedGraph {
    public int solve(int n, int[][] grid) {
        List<Integer> graph[] = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int row[] : grid) {
            int u = row[0], v = row[1];
            graph[u].add(v);
        }

        boolean visited[] = new boolean[n + 1];

        return dfs(graph, 1, n, visited) ? 1 : 0;

    }

    boolean dfs(List<Integer> graph[], int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;
        for (int nbr : graph[src]) {
            if (!visited[nbr]) {
                boolean path = dfs(graph, nbr, dest, visited);
                if (path) {
                    return true;
                }
            }
        }

        return false;

    }
}
