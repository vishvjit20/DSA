package Trie;

import java.util.*;

public class ModifiedSearch {
    class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        boolean search(String str) {
            Node curr = root;
            for (char c : str.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
            return curr.isEnd;
        }
    }

    public String solve(String[] A, String[] B) {
        Trie trie = new Trie();
        StringBuilder res = new StringBuilder();
        for (String word : A)
            trie.insert(word);

        HashSet<String> set = new HashSet<>();
        for (String word : B) {
            boolean flag = false;
            set.add(word);
            char[] w = word.toCharArray();
            for (int j = 0; j < word.length(); j++) {
                char ch = w[j];
                for (char k = 'a'; k <= 'z'; k++) {
                    w[j] = k;
                    String str = new String(w);
                    if (set.contains(str))
                        continue;
                    flag = trie.search(str);
                    if (flag)
                        break;
                }
                if (!flag)
                    w[j] = ch;
                else
                    break;
            }
            if (flag)
                res.append(1);
            else
                res.append(0);
        }

        return res.toString();
    }
}
