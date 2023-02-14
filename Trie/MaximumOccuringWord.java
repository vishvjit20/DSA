package Trie;

import java.util.*;

public class MaximumOccuringWord {
    static class Node {
        Map<Character, Node> children = new HashMap<>();
        int count;
        String key;
    }

    static Node root;

    static class Trie {

        public Trie() {
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

        int preorder(Node curr, int maxCount, StringBuilder key) {
            if (curr == null) {
                return maxCount;
            }

            for (var entry : curr.children.entrySet()) {
                if (maxCount < entry.getValue().count) {
                    key.replace(0, key.length(), entry.getValue().key);
                    maxCount = entry.getValue().count;
                }
                maxCount = preorder(entry.getValue(), maxCount, key);
            }
            return maxCount;
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codec", "codecs", "codependence", "codex", "codify",
                "codependents", "codes", "code", "coder", "codesign", "codec",
                "codeveloper", "codrive", "codec", "codecs", "codiscovered");

        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        int count = 0;
        StringBuilder key = new StringBuilder();

        Node curr = root;
        count = trie.preorder(curr, count, key);

        System.out.println("Word : " + key);
        System.out.println("Count: " + count);
    }
}
