import java.util.*;

public class Batches {
    static class Pair {
        int vtx, wt;

        public Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }
    }

    static int cnt = 0;

    public static int solve(int A, int[] B, int[][] C, int D) {
new
        ArrayList<Pair>[] graph = new ArrayList[A];
        for (int i = 0; i < A; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int row[] : C) {
            int u = row[0] - 1;
            int v = row[1] - 1;
            graph[u].add(new Pair(v, B[u]));
            graph[v].add(new Pair(u, B[v]));
        }
        int count = 0;
        boolean[] vis = new boolean[A];
        for (int idx = 0; idx < A; idx++) {
            if (!vis[idx]) {
                cnt = B[idx];
                dfs(A, graph, idx, vis);
                System.out.println("COUNT " + cnt);
                if (cnt >= D)
                    count++;
            }
        }

        return count;
    }

    static void dfs(int n, ArrayList<Pair>[] graph, int src, boolean visited[]) {
        visited[src] = true;

        for (Pair nbr : graph[src]) {
            if (!visited[nbr.vtx]) {
                cnt += nbr.wt;
                dfs(n, graph, nbr.vtx, visited);
                // cnt -= nbr.wt;
            }
        }
    }

    public static void main(String args[]) {
        int A = 10;
        int B[] = { 7, 9, 3, 2, 9, 1, 6, 4, 10, 8 };
        int C[][] = {
                { 1, 5 },
                { 2, 6 },
                { 3, 7 },
                { 3, 9 },
                { 3, 10 },
                { 4, 5 },
                { 4, 7 },
                { 4, 10 },
                { 5, 7 },
                { 7, 9 }
        };
        int D = 26;

        int res = solve(A, B, C, D);
        System.out.println(res);

    }
}
