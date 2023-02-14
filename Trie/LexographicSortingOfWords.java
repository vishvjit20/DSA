package Trie;

public class LexographicSortingOfWords {
    static class Node {
        Node[] children = new Node[26];
        String key;
        boolean isEnd = false;
    }

    static Node root;

    static class Trie {
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
            curr.key = word;
            curr.isEnd = true;
        }

        void preorder(Node curr) {
            if (curr == null)
                return;

            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null && curr.children[i].key != null) {
                    System.out.println(curr.children[i].key);
                }
                preorder(curr.children[i]);
            }
        }
    }

    public static void main(String[] args) {
        String s = "lexicographic sorting of a set of keys can be accomplished with " +
                "a simple trie based algorithm we insert all keys in a trie output " +
                "all keys in the trie by means of preorder traversal which results " +
                "in output that is in lexicographically increasing order preorder " +
                "traversal is a kind of depth first traversal";
        Trie trie = new Trie();
        String[] dict = s.split(" ");
        for (String word : dict)
            trie.insert(word);
        trie.preorder(root);
    }
}
