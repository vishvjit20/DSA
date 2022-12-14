package Graphs;

import java.util.*;

public class GetConnectedComponents {

    public static void main(String args[]) {
        int vtcs = 7;
        // int edges = 5;
        int rows[][] = { { 0, 1 }, { 2, 3 }, { 4, 5 }, { 5, 6 }, { 4, 6 } };
        ArrayList<Integer>[] graph = new ArrayList[vtcs];
        for (int i = 0; i < vtcs; i++)
            graph[i] = new ArrayList<>();

        for (int row[] : rows) {
            int u = row[0];
            int v = row[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean visited[] = new boolean[vtcs];

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < vtcs; i++) {
            if (!visited[i]) {
                ArrayList<Integer> list = new ArrayList<>();
                dfs(graph, i, visited, list);
                res.add(list);
            }
        }

        System.out.println(res);
    }

    static void dfs(ArrayList<Integer>[] graph, int src, boolean[] visited,
            ArrayList<Integer> list) {

        visited[src] = true;
        list.add(src);
        for (int nbr : graph[src]) {
            if (!visited[nbr]) {
                dfs(graph, nbr, visited, list);
            }
        }
    }
}
