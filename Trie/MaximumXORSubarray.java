package Trie;

import java.util.*;

class MaximumXORSubarray {
    class Node {
        Node children[];
        boolean isEnd = false;

        Node() {
            children = new Node[2];
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(int n) {
            Node curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (n >> i) & 1;
                if (curr.children[bit] == null) {
                    curr.children[bit] = new Node();
                }
                curr = curr.children[bit];
            }
            curr.isEnd = true;
        }

        int maxSubarrayXOR(int n) {
            Node curr = root;
            int res = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (n >> i) & 1;
                int cbit = bit ^ 1;
                if (curr.children[cbit] != null) {
                    res |= (1 << i);
                    curr = curr.children[cbit];
                } else {
                    curr = curr.children[bit];
                }
            }

            return res;
        }
    }

    int[] solve(int A[]) {
        int n = A.length;
        int preXOR[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            preXOR[i] = preXOR[i - 1] ^ A[i - 1];
        }
        Trie trie = new Trie();
        int maxXOR = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            trie.insert(preXOR[i]);
            int xor = trie.maxSubarrayXOR(preXOR[i]);
            maxXOR = Math.max(maxXOR, xor);
        }

        Map<Integer, Integer> map = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int minStart = Integer.MAX_VALUE;
        int minEnd = Integer.MAX_VALUE;
        for (int i = 0; i < preXOR.length; i++) {
            int val = maxXOR ^ preXOR[i];
            if (map.containsKey(val)) {
                int start = map.get(val) + 1;
                int end = i;
                int len = end - start + 1;
                if (len < minLen) {
                    minLen = len;
                    minStart = start;
                    minEnd = end;
                } else if (len == minLen && start < minStart) {
                    minLen = len;
                    minStart = start;
                    minEnd = end;
                }
            }
            map.put(preXOR[i], i);
        }
        return new int[] { minStart, minEnd };
    }
}
