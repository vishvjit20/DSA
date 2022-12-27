package Trie;

public class MaximumXOR {
    class Node {
        Node[] children = new Node[2];
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
        }

        int maxXOR(int n) {
            Node curr = root;
            int curr_max = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (n >> i) & 1;

                if (bit == 1) {
                    if (curr.children[0] != null) {
                        curr_max += (1 << i);
                        curr = curr.children[0];
                    } else
                        curr = curr.children[1];
                } else {
                    if (curr.children[1] != null) {
                        curr_max += (1 << i);
                        curr = curr.children[1];
                    } else
                        curr = curr.children[0];
                }
            }
            return curr_max;
        }
    }

    int solve(int arr[]) {
        Trie trie = new Trie();
        int max = 0;
        trie.insert(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, trie.maxXOR(arr[i]));
            trie.insert(arr[i]);
        }
        return max;
    }
}
