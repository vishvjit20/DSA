package Trees;

public class LargestBSTSubtree {
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

    class NodeValue {
        int minVal, maxVal, maxSize;

        public NodeValue(int minVal, int maxVal, int maxSize) {
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.maxSize = maxSize;
        }
    }

    NodeValue largestBSTHelper(TreeNode root) {
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);

        if (root.val > left.maxVal && root.val < right.minVal) {
            return new NodeValue(Math.min(left.minVal, root.val), Math.max(right.maxVal, root.val),
                    left.maxSize + right.maxSize + 1);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public int solve(TreeNode A) {
        if (A == null)
            return 0;
        return largestBSTHelper(A).maxSize;
    }
}
