import java.util.*;

class Node {
    int key, val;
    Node next, prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node first, last;
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        first = new Node(0, 0);
        last = new Node(0, 0);
        first.next = last;
        last.prev = first;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        remove(node);
        insert(node);
        return node.key;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (this.capacity == map.size()) {
            remove(last.prev);
        }
        insert(new Node(key, value));
    }

    void insert(Node node) {
        map.put(node.key, node);
        first.next.prev = node;
        node.next = first.next;
        node.prev = first;
        first.next = node;
    }

    void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
}
