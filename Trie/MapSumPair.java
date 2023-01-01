package Trie;

import java.util.*;

public class MapSumPair {
    class Node {
        int sumKeyValue;
        Node[] children = new Node[26];
    }

    Map<String, Integer> keyValueMap = new HashMap<>();

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word, int ele) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node();
                }
                curr = curr.children[c - 'a'];
                if (keyValueMap.containsKey(word)) {
                    curr.sumKeyValue -= keyValueMap.get(word);
                    curr.sumKeyValue += ele;
                } else
                    curr.sumKeyValue += ele;
            }
        }

        int sumTrie(String prefix) {
            Node curr = root;
            for (char c : prefix.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    return 0;
                }
                curr = curr.children[c - 'a'];
            }
            return curr.sumKeyValue;
        }
    }

    public int[] solve(String[] A, int[] B) {
        Trie trie = new Trie();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (B[i] != -1) {
                trie.insert(A[i], B[i]);
                keyValueMap.put(A[i], B[i]);
            } else {
                int val = trie.sumTrie(A[i]);
                list.add(val);
            }
        }
        return list.stream().mapToInt(v -> v).toArray();
    }
}
