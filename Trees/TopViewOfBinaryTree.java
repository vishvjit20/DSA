package Trees;

import java.util.*;

public class TopViewOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    class Pair {
        TreeNode node;
        int lvl;

        public Pair(TreeNode node, int lvl) {
            this.node = node;
            this.lvl = lvl;
        }
    }

    int width[];

    void calcWidth(TreeNode root, int level) {
        if (root == null)
            return;
        width[0] = Math.min(width[0], level);
        width[1] = Math.max(width[1], level);
        calcWidth(root.left, level - 1);
        calcWidth(root.right, level + 1);
    }

    public int[] solve(TreeNode A) {
        if (A == null)
            return new int[] {};
        width = new int[2];
        calcWidth(A, 0);
        int len = width[1] - width[0] + 1;
        int res[] = new int[len];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(A, -width[0]));
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                Pair rem = q.remove();
                TreeNode node = rem.node;
                int lvl = rem.lvl;
                if (res[lvl] == 0) {
                    res[lvl] = node.val;
                }
                if (node.left != null)
                    q.add(new Pair(node.left, lvl - 1));
                if (node.right != null)
                    q.add(new Pair(node.right, lvl + 1));
            }
        }
        return res;
    }
}
