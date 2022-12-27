package Trie;

import java.util.*;

public class ShortestUniquePrefix {
    static class Node {
        Node[] children = new Node[26];
        int count;
    }

    static class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        void inser(String word) {
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
            int idx = 0;
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.count == 1)
                    return idx;
                else {
                    idx++;
                    curr = curr.children[c - 'a'];
                }
            }
            return idx;
        }

    }

    static public String[] prefix(String[] A) {
        Trie trie = new Trie();
        for (String word : A)
            trie.inser(word);

        ArrayList<String> res = new ArrayList<>();
        for (String word : A) {
            int idx = trie.find(word);

            res.add(word.substring(0, idx));
        }

        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        String str[] = { "zebra", "dog", "duck", "dove" };
        String[] res = prefix(str);
        System.out.println(Arrays.toString(res));
    }
}
