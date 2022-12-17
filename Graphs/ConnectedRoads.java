import java.util.*;

public class ConnectedRoads {
    public int solve(int n, int[][] grid) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int MOD = 1000000007;
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int row[] : grid) {
            int u = row[0], v = row[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] visited = new int[n + 1];
        bfs(graph, visited);
        long oneCnt = 0, twoCnt = 0;
        for (int vis : visited) {
            if (vis == 1)
                oneCnt++;
            else if (vis == 2)
                twoCnt++;
        }
        oneCnt %= MOD;
        twoCnt %= MOD;
        int prod = (int) ((1L * oneCnt * twoCnt) % MOD);
        return prod - n + 1;
    }

    void bfs(ArrayList<Integer>[] graph, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;
        while (!q.isEmpty()) {
            int rem = q.remove();
            int remColor = visited[rem];
            for (int nbr : graph[rem]) {
                int nbrColor = visited[nbr];
                if (nbrColor == 0) {
                    visited[nbr] = remColor == 1 ? 2 : 1;
                    q.add(nbr);
                }
            }
        }
    }
}
