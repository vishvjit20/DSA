import java.util.*;

public class FirstDepthFirstSearch {
    public int solve(int[] A, final int dest, final int src) {
        int n = A.length;
        List<Integer> graph[] = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            graph[A[i]].add(i + 1);
        }

        boolean visited[] = new boolean[n + 1];

        return dfs(graph, src, dest, visited) ? 1 : 0;
    }

    boolean dfs(List<Integer>[] graph, int src, int dest, boolean[] visited) {
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
