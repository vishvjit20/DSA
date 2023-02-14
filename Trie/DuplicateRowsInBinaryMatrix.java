package Trie;

public class DuplicateRowsInBinaryMatrix {
    static class Node {
        Node children[] = new Node[2];
        boolean isEnd;
    }

    static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        boolean insert(int[] row) {
            Node curr = root;
            for (int val : row) {
                if (curr.children[val] == null) {
                    curr.children[val] = new Node();
                }
                curr = curr.children[val];
            }
            if (curr.isEnd) {
                return false;
            }
            return curr.isEnd = true;
        }
    }

    public static void main(String[] args) {
        int mat[][] = {
                { 1, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0 },
                { 1, 0, 0, 1, 0 },
                { 0, 0, 1, 1, 0 },
                { 0, 1, 1, 0, 0 }
        };

        Trie trie = new Trie();
        for (int i = 0; i < mat.length; i++) {
            boolean isAbsent = trie.insert(mat[i]);
            if (!isAbsent) {
                System.out.println("Row " + (i + 1) + " is already present.");
            }
        }

    }
}
