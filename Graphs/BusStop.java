import java.util.*;

public class BusStop {
    class Pair {
        int busStop;
        int level;

        Pair(int busStop, int level) {
            this.busStop = busStop;
            this.level = level;
        }
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> list = map.getOrDefault(routes[i][j], new ArrayList<>());
                list.add(i);
                map.put(routes[i][j], list);
            }
        }

        return bfs(routes, source, target, map);
    }

    int bfs(int[][] routes, int src, int dest, Map<Integer, ArrayList<Integer>> map) {
        Set<Integer> busStopVis = new HashSet<>();
        Set<Integer> busVis = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        busStopVis.add(src);
        while (!q.isEmpty()) {
            Pair rem = q.remove();
            if (rem.busStop == dest) {
                return rem.level;
            }
            ArrayList<Integer> buses = map.get(rem.busStop);
            for (int bus : buses) {
                if (!busVis.contains(bus)) {
                    busVis.add(bus);
                    for (int busStop : routes[bus]) {
                        if (!busStopVis.contains(busStop)) {
                            q.add(new Pair(busStop, rem.level + 1));
                            busStopVis.add(busStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
