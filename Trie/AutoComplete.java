package Trie;

import java.util.*;

public class AutoComplete {
    static class Pair {
        private String word;
        private int wt;

        public Pair(String word, int wt) {
            this.word = word;
            this.wt = wt;
        }

        public int getWeight() {
            return this.wt;
        }

        public String getWord() {
            return this.word;
        }

    }

    static class Node {
        private Node children[];
        private boolean isEnd;
        private char c;
        private LinkedList<Pair> suggestions;

        public Node() {
            this.children = new Node[26];
            this.isEnd = false;
            this.suggestions = new LinkedList<>();
        }

        public Node(char c) {
            this();
            this.c = c;
        }
    }

    static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word, int wt) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node(c);
                }
                curr = curr.children[c - 'a'];
                curr.suggestions.add(new Pair(word, wt));
                Collections.sort(curr.suggestions, (a, b) -> b.wt - a.wt);
                if (curr.suggestions.size() > 5) {
                    curr.suggestions.pollLast();
                }
            }
            curr.isEnd = true;
        }

        public List<Pair> search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    return new LinkedList<>();
                }
                curr = curr.children[c - 'a'];
            }
            return curr.suggestions;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            Trie trie = new Trie();
            int n, m;
            n = scn.nextInt();
            m = scn.nextInt();
            String prefixes[] = new String[m];
            String dict[] = new String[n];
            for (int i = 0; i < n; i++) {
                dict[i] = scn.next();
            }
            int weights[] = new int[n];
            for (int i = 0; i < n; i++) {
                weights[i] = scn.nextInt();
            }

            for (int i = 0; i < m; i++) {
                prefixes[i] = scn.next();
            }

            for (int i = 0; i < n; i++) {
                trie.insert(dict[i], weights[i]);
            }

            for (int i = 0; i < m; i++) {
                List<Pair> res = trie.search(prefixes[i]);
                if (res.size() == 0) {
                    System.out.println(-1 + " ");
                } else {
                    res.stream().filter(p -> p != null).forEach(p -> System.out.print(p.getWord() + " "));
                    System.out.println();
                }
            }

        }

        scn.close();
    }
}
