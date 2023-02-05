package Trie;

public class SpellingChecker {
    class Node {
        Node children[];
        boolean isEnd;

        Node() {
            children = new Node[26];
            isEnd = false;
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String str) {
            Node curr = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        boolean isWordPresent(String str) {
            Node curr = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }

            return curr.isEnd;
        }
    }

    public int[] solve(String[] A, String[] B) {
        Trie trie = new Trie();
        for (String word : A)
            trie.insert(word);

        int n = B.length;
        int res[] = new int[n];
        int idx = 0;
        for (String word : B) {
            boolean isPresent = trie.isWordPresent(word);
            if (isPresent) {
                res[idx] = 1;
            }
            idx++;
        }

        return res;
    }
}
