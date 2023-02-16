package Trees;

import java.util.*;

public class BottomView {
    class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    class Pair {
        Node node;
        int level;

        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    int width[] = new int[2];

    void calcWidth(Node root, int level) {
        if (root == null) {
            return;
        }

        width[0] = Math.min(width[0], level);
        width[1] = Math.max(width[1], level);

        calcWidth(root.left, level - 1);
        calcWidth(root.right, level + 1);
    }

    public ArrayList<Integer> bottomView(Node root) {
        if (root == null)
            return new ArrayList<>();
        calcWidth(root, 0);
        int len = width[1] - width[0] + 1;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++)
            res.add(null);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, -width[0]));
        while (!q.isEmpty()) {
            Pair rem = q.remove();
            int lvl = rem.level;
            Node node = rem.node;
            res.set(lvl, node.data);
            if (node.left != null) {
                q.add(new Pair(node.left, lvl - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, lvl + 1));
            }
        }

        return res;
    }
}
