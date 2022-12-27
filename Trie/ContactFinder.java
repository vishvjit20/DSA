package Trie;

import java.util.*;

public class ContactFinder {
    static class Node {
        Node[] children = new Node[26];
        int count;
    }

    static class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node();
                }
                curr.count++;
                curr = curr.children[c - 'a'];
            }
        }

        int find(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    return 0;
                }
                curr = curr.children[c - 'a'];
            }

            return curr.count;
        }

        public int[] solve(int[] A, String[] B) {
            ArrayList<Integer> res = new ArrayList<>();
            Trie trie = new Trie();
            for (int i = 0; i < A.length; i++) {
                if (A[i] == 0) {
                    trie.insert(B[i]);
                } else {
                    int val = trie.find(B[i]);
                    res.add(val);
                }
            }

            return res.stream().mapToInt(v -> v).toArray();
        }

    }
}
