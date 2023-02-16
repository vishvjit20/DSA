package Trees;

public class SortedArrayToBalancedBST {
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

    TreeNode constructBST(final int A[], int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = constructBST(A, left, mid - 1);
        node.right = constructBST(A, mid + 1, right);
        return node;
    }

    public TreeNode sortedArrayToBST(final int[] A) {
        int left = 0, right = A.length - 1;
        return constructBST(A, left, right);
    }
}
