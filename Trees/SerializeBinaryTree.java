package Trees;

import java.util.*;

public class SerializeBinaryTree {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode rem = q.remove();
                res.add(rem.val);
                if (rem.val != -1 && rem.left == null) {
                    TreeNode node = new TreeNode(-1);
                    q.add(node);
                } else if (rem.left != null)
                    q.add(rem.left);
                if (rem.val != -1 && rem.right == null) {
                    TreeNode node = new TreeNode(-1);
                    q.add(node);
                } else if (rem.right != null)
                    q.add(rem.right);
            }
        }

        return res;
    }
}
