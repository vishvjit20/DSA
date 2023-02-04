package Trees;

import java.util.*;

public class RightViewOfABinaryTree {
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

    public int[] solve(TreeNode root) {
        if (root == null)
            return new int[] {};
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            list.add(q.peek().val);
            while (size-- > 0) {
                TreeNode rem = q.remove();
                if (rem.right != null) {
                    q.add(rem.right);
                }
                if (rem.left != null) {
                    q.add(rem.left);
                }
            }
        }

        return list.stream().mapToInt(v -> v).toArray();
    }
}
