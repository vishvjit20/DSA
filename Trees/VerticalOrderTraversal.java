package Trees;

import java.util.*;

public class VerticalOrderTraversal {
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

    int width[];

    class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    void widthCalc(TreeNode root, int level) {
        if (root == null)
            return;
        width[0] = Math.min(width[0], level);
        width[1] = Math.max(width[1], level);

        widthCalc(root.left, level - 1);
        widthCalc(root.right, level + 1);
    }

    public int[][] verticalOrderTraversal(TreeNode root) {
        width = new int[2];
        widthCalc(root, 0);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, -width[0]));
        int len = width[1] - width[0] + 1;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new ArrayList<>());
        }
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                Pair rem = q.remove();
                TreeNode node = rem.node;
                int level = rem.level;
                list.get(level).add(node.val);
                if (node.left != null) {
                    q.add(new Pair(node.left, level - 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, level + 1));
                }
            }
        }
        return list.stream().map(l -> l.stream().mapToInt(v -> v).toArray()).toArray(int[][]::new);
    }
}
