import java.util.*;

public class TopologicalSort {
    public int[] solve(int n, int[][] grid) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDeg = new int[n + 1];
        int res[] = new int[n];
        int idx = 0;
        for (int row[] : grid) {
            int u = row[0];
            int v = row[1];
            inDeg[v]++;
            graph[u].add(v);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        while (q.size() > 0) {
            int x = q.remove();
            res[idx++] = x;

            for (int nbr : graph[x]) {
                inDeg[nbr]--;
                if (inDeg[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }
        return res;
    }
}
