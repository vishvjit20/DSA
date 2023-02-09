package Trie;

import java.util.*;

public class WordSearch2 {
    class Node {
        Node children[] = new Node[26];
        boolean isEnd;
    }

    Node root;

    class Trie {

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
    }

    boolean[][] flag;

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        flag = new boolean[n][m];
        Set<String> res = new HashSet<>();

        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    search(board, i, j, root, "", res);
                }
            }
        }

        return new LinkedList<>(res);
    }

    void search(char[][] board, int i, int j, Node node, String word, Set<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || flag[i][j]
                || node.children[board[i][j] - 'a'] == null) {
            return;
        }

        flag[i][j] = true;
        node = node.children[board[i][j] - 'a'];
        if (node.isEnd)
            res.add(word + board[i][j]);

        search(board, i + 1, j, node, word + board[i][j], res);
        search(board, i, j + 1, node, word + board[i][j], res);
        search(board, i, j - 1, node, word + board[i][j], res);
        search(board, i - 1, j, node, word + board[i][j], res);

        flag[i][j] = false;
    }
}
