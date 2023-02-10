package Trie;

import java.util.*;

public class LongestCommonPrefixInSetOfStrings {
    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isEnd = false;
    }

    static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new Node());
                curr = curr.children.get(c);
            }
            curr.isEnd = true;
        }

        String findLongestCommonPrefix() {
            Node curr = root;
            StringBuilder lcp = new StringBuilder();
            while (curr != null && !curr.isEnd && curr.children.size() == 1) {
                for (var entry : curr.children.entrySet()) {
                    lcp.append(entry.getKey());
                    curr = entry.getValue();
                }
            }
            return lcp.toString();
        }
    }

    public static void main(String args[]) {
        List<String> dict = Arrays.asList(
                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codependence", "codependency", "codependent",
                "codependents", "codes", "codesign", "codesigned", "codeveloped",
                "codeveloper", "codex", "codify", "codiscovered", "codrive");

        Trie trie = new Trie();
        for (String str : dict)
            trie.insert(str);

        System.out.println("The longest common prefix is " + trie.findLongestCommonPrefix());
    }
}
