package Trees;

public class ValidateBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    boolean isValidBSTHelper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBSTHelper(root.left, min, root.val - 1);
        boolean right = isValidBSTHelper(root.right, root.val + 1, max);
        if (root.val < min || root.val > max) {
            return false;
        }
        return left && right;

    }

    public int isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }
}
