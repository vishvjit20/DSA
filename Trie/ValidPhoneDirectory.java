package Trie;

public class ValidPhoneDirectory {
    class Node {
        Node[] children = new Node[10];
    }

    class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        boolean insert(String word) {
            Node curr = root;
            boolean isPrefix = true;
            for (char c : word.toCharArray()) {
                if (curr.children[c - '0'] == null) {
                    isPrefix = false;
                    curr.children[c - '0'] = new Node();
                }
                curr = curr.children[c - '0'];
            }
            return isPrefix;
        }

    }

    public int solve(String[] A) {
        Trie trie = new Trie();
        for (int i = 0; i < A.length; i++) {
            boolean res = trie.insert(A[i]);
            if (res)
                return 0;
        }
        return 1;
    }
}
