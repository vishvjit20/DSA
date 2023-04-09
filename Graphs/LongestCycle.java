import java.util.*;

public class LongestCycle {
    public int longestCycle(int edges[]) {
        int n = edges.length;
        int res = -1;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int idx = i, dist = 0; idx != -1; idx = edges[idx]) {
                if (map.containsKey(idx)) {
                    res = Math.max(res, dist - map.get(idx));
                    break;
                }
                if (visited[idx])
                    break;
                visited[idx] = true;
                map.put(idx, dist++);
            }
        }

        return res;
    }
}
