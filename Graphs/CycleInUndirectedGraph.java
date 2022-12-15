package Graphs;

import java.util.*;

public class CycleInUndirectedGraph {
    void dfs(ArrayList<Integer> graph[], int src, boolean[] visited) {
        visited[src] = true;
        for (int nbr : graph[src]) {
            if (!visited[nbr]) {
                dfs(graph, nbr, visited);
            }
        }
    }

    public int solve(int n, int[][] grid) {
        ArrayList<Integer> graph[] = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        int edges = 0;
        int no_of_connected_components = 0;
        for (int row[] : grid) {
            int u = row[0], v = row[1];
            graph[u].add(v);
            graph[v].add(u);
            edges++;
        }
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                no_of_connected_components++;
            }
        }

        if (n == no_of_connected_components + edges) {
            return 0;
        }
        return 1;
    }

}
