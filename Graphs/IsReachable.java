package Graphs;

import java.util.*;

public class IsReachable {
    public static int solve(int[] A, final int B, final int C) {
        int n = A.length + 1;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            graph[A[i]].add(i + 1);
        }

        System.out.println(graph);

        boolean[] visited = new boolean[n];
        isPath(graph, C, B, visited);

        return visited[B] ? 1 : 0;

    }

    static void isPath(ArrayList<Integer>[] graph, int src, int dest, boolean[] visited) {
        if (visited[src]) {
            return;
        }
        visited[src] = true;
        for (int nbr : graph[src]) {
            if (!visited[nbr]) {
                isPath(graph, nbr, dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 3, 3, 2, 2, 7, 6 };
        int res = solve(arr, 9, 1);
        System.out.println(res);
    }
}
