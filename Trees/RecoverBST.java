package Trees;

public class RecoverBST {
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

    TreeNode prev, first, mid, last;

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                mid = root;
            } else
                last = root;
        }
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        prev = null;
        first = null;
        mid = null;
        last = null;
        inorder(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && mid != null) {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }
}
