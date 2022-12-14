package Graphs;

import java.util.*;

public class IsReachable {
    public static int solve(int[] A, final int B, final int C) {
        int n = A.length;
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(A[i])) {
                graph.put(A[i], new ArrayList<>());
            }

            ArrayList<Integer> list = graph.getOrDefault(A[i], new ArrayList<>());
            if (i + 1 != A[i])
                list.add(i + 1);
            graph.put(A[i], list);
        }
        if (!graph.containsKey(C))
            return 0;

        Set<Integer> visited = new HashSet<>();
        boolean path = isPath(graph, C, B, visited);

        return path ? 1 : 0;

    }

    static boolean isPath(Map<Integer, ArrayList<Integer>> graph, int src, int dest, Set<Integer> visited) {
        if (src == dest) {
            return true;
        }
        visited.add(src);
        for (Integer nbr : graph.getOrDefault(src, new ArrayList<>())) {
            if (!visited.contains(nbr)) {
                boolean path = isPath(graph, nbr, dest, visited);
                if (path) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 3, 3, 2, 2, 7, 6 };
        int res = solve(arr, 9, 1);
        System.out.println(res);
    }
}
