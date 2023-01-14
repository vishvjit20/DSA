package LinkedList;

public class FlattenALinkedList {
    class ListNode {
        int val;
        ListNode right, down;

        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }

    ListNode mergeTwoLinkedLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.down = l1;
                temp = temp.down;
                l1 = l1.down;
            } else {
                temp.down = l2;
                temp = temp.down;
                l2 = l2.down;
            }
        }
        if (l1 != null) {
            temp.down = l1;
        } else
            temp.down = l2;
        return res.down;
    }

    ListNode flatten(ListNode root) {
        if (root == null || root.right == null) {
            return root;
        }

        root.right = flatten(root.right);
        root = mergeTwoLinkedLists(root, root.right);
        return root;
    }
}
