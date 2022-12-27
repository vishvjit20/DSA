package Trees;

import java.util.*;

public class BSTIterator {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Stack<TreeNode> stk = new Stack<>();

    BSTIterator(TreeNode root) {
        pushAll(root);
    }

    void pushAll(TreeNode node) {
        for (; node != null; stk.push(node), node = node.left)
            ;
    }

    boolean hasNext() {
        return !stk.isEmpty();
    }

    int next() {
        TreeNode temp = stk.pop();
        pushAll(temp.right);
        return temp.val;
    }
}
