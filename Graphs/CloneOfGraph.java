import java.util.*;

public class CloneOfGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Node BFS(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        if (node != null) {
            map.put(node, new Node(node.val));
            q.add(node);
        }
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            for (Node nbr : currNode.neighbors) {
                if (!map.containsKey(nbr)) {
                    map.put(nbr, new Node(nbr.val));
                    q.add(nbr);
                }
                map.get(currNode).neighbors.add(map.get(nbr));
            }
        }
        return map.get(node);
    }

    public Node cloneGraph(Node node) {
        return BFS(node);
    }
}
