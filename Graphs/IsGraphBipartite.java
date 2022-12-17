package Graphs;

import java.util.*;

public class IsGraphBipartite {
    class Pair {
        int vtx, level;

        public Pair(int vtx, int level) {
            this.vtx = vtx;
            this.level = level;
        }
    }

    public int solve(int n, int[][] grid) {

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int row[] : grid) {
            int u = row[0];
            int v = row[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                boolean isBipartite = isComponentBiPartite(graph, i, visited);
                if (!isBipartite) {
                    return 0;
                }
            }
        }
        return 1;
    }

    boolean isComponentBiPartite(ArrayList<Integer>[] graph, int src, int[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        while (!q.isEmpty()) {
            Pair rem = q.remove();
            if (visited[rem.vtx] == -1) {
                visited[rem.vtx] = rem.level;
            } else {
                if (rem.level != visited[rem.vtx]) {
                    return false;
                }
            }

            for (int nbr : graph[rem.vtx]) {
                if (visited[nbr] == -1) {
                    q.add(new Pair(nbr, rem.level + 1));
                }
            }
        }
        return true;
    }
}
