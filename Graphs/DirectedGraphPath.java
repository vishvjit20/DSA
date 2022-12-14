package Graphs;

import java.util.*;

public class DirectedGraphPath {
    public int solve(int n, int[][] grid) {

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int row[] : grid) {
            graph[row[0] - 1].add(row[1] - 1);
        }

        boolean visited[] = new boolean[n];
        boolean path = isPath(graph, 0, n - 1, visited);

        return path ? 1 : 0;

    }

    boolean isPath(ArrayList<Integer> graph[], int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }
        visited[src] = true;
        for (int nbr : graph[src]) {
            if (!visited[nbr]) {
                boolean path = isPath(graph, nbr, dest, visited);
                if (path) {
                    return true;
                }
            }
        }
        return false;
    }

}
