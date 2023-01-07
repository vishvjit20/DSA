package Trees;

public class DistanceBetweenNodesOfBST {
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

    public int solve(TreeNode A, int B, int C) {
        int min = Math.min(C, B);
        int max = Math.max(C, B);
        TreeNode curr = A;
        while (curr.val < min || curr.val > max) {
            if (curr.val < min)
                curr = curr.right;
            if (curr.val > max)
                curr = curr.left;
        }

        int l = dist(curr, min);
        int r = dist(curr, max);

        return l + r;
    }

    int dist(TreeNode root, int x) {
        if (root.val == x)
            return 0;
        else if (root.val > x)
            return 1 + dist(root.left, x);
        else
            return 1 + dist(root.right, x);
    }
}
