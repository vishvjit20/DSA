package Trees;

public class ConstructBinaryTreeFromInorderAndPostOrder {
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

    TreeNode constructTree(int[] in, int[] post, int is, int ie, int ps, int pe) {
        if (ps > pe)
            return null;
        TreeNode node = new TreeNode(post[pe]);
        int k = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == node.val) {
                k = i;
                break;
            }
        }
        int cls = k - is;
        node.left = constructTree(in, post, is, k - 1, ps, ps + cls - 1);
        node.right = constructTree(in, post, k + 1, ie, ps + cls, pe - 1);

        return node;

    }

    public TreeNode buildTree(int[] in, int[] post) {
        int n = in.length;

        return constructTree(in, post, 0, n - 1, 0, n - 1);
    }
}
