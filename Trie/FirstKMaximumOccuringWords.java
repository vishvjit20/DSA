package Trie;

import java.util.*;

public class FirstKMaximumOccuringWords {
    static class Node implements Comparable<Node> {
        Map<Character, Node> children = new HashMap<>();
        String key;
        int count;

        Node() {
        }

        public Node(String key, int count) {
            this.key = key;
            this.count = count;
        }

        public int compareTo(Node n) {
            return n.count - this.count;
        }
    }

    static Node root;

    static class Trie {

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new Node());
                curr = curr.children.get(c);
            }
            curr.key = word;
            curr.count += 1;
        }

        void preorder(Node curr, PriorityQueue<Node> q) {
            if (curr == null) {
                return;
            }

            for (var entry : curr.children.entrySet()) {
                if (entry.getValue().count != 0)
                    q.add(new Node(entry.getValue().key, entry.getValue().count));
                preorder(entry.getValue(), q);
            }

        }
    }

    public static void main(String[] args) {
        String[] dict = {
                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codec", "codecs", "codependence", "codex", "codify",
                "codependents", "codes", "code", "coder", "codesign", "codec",
                "codeveloper", "codrive", "codec", "codecs", "codiscovered"
        };

        int k = 4;

        Trie trie = new Trie();
        for (String word : dict)
            trie.insert(word);

        PriorityQueue<Node> q = new PriorityQueue<>();
        Node curr = root;
        trie.preorder(curr, q);

        while (k-- > 0 && !q.isEmpty()) {
            Node max = q.poll();
            System.out.println(max.key + " occurs " + max.count + " times");
        }
    }
}
