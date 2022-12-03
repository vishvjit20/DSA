package HashMap;

import java.util.*;

public class ReconstructItinerary {
    static LinkedList<String> res;

    static Map<String, PriorityQueue<String>> iteneraryMap;

    public static List<String> findItinerary(List<List<String>> tickets) {
        res = new LinkedList<>();
        iteneraryMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            PriorityQueue<String> tempQue = iteneraryMap.getOrDefault(ticket.get(0), new PriorityQueue<>());
            tempQue.add(ticket.get(1));
            iteneraryMap.put(ticket.get(0), tempQue);
        }

        dfs("JFK");
        return res;
    }

    public static void dfs(String src) {
        PriorityQueue<String> nbrs = iteneraryMap.get(src);
        while (nbrs != null && nbrs.size() > 0) {
            String nbr = nbrs.remove();
            dfs(nbr);
        }
        res.addFirst(src);
    }
}
