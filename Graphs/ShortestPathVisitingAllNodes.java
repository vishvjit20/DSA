import java.util.*;

public class ShortestPathVisitingAllNodes {
    class Node {
        int node, vis, dist;

        public Node(int node, int vis, int dist) {
            this.node = node;
            this.vis = vis;
            this.dist = dist;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<Node> q = new LinkedList<>();
        int finalState = (1 << n) - 1;
        Set<Integer>[] visited = new HashSet[n];
        for (int i = 0; i < n; i++) {
            visited[i] = new HashSet<>();
            q.add(new Node(i, 1 << i, 0));
            visited[i].add(1 << i);
        }
        while (q.size() > 0) {
            Node rem = q.remove();
            if (rem.vis == finalState) {
                return rem.dist;
            }
            for (int nbr : graph[rem.node]) {
                int mask = rem.vis | 1 << nbr;
                if (!visited[nbr].contains(mask)) {
                    visited[nbr].add(mask);
                    q.add(new Node(nbr, mask, rem.dist + 1));
                }
            }
        }

        return -1;
    }
}
