package Graphs;

import java.util.*;

public class PathInAGraph {
    static class Edge {
        int src, nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]) {
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                boolean hasPath = hasPath(graph, edge.nbr, dest, visited);
                if (hasPath)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int vtces = 7;
        int src = 0;
        int dest = 6;
        int points[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 4, 6 } };

        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++)
            graph[i] = new ArrayList<>();

        for (int point[] : points) {
            int u = point[0];
            int v = point[1];

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }
        boolean visited[] = new boolean[vtces];
        boolean hasPath = hasPath(graph, src, dest, visited);
        System.out.println(hasPath);
    }
}
