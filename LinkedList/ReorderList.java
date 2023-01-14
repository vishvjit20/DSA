package LinkedList;

public class ReorderList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode middleOfList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode slow = node, fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode prev = null, curr = node;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return node = prev;
    }

    private ListNode merge2Lists(ListNode A, ListNode B) {
        ListNode l1 = A, l2 = B;
        ListNode res = l1;
        while (l2 != null) {
            ListNode temp = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l1.next.next;
            l2 = temp;
        }
        return res;
    }

    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = middleOfList(head);
        ListNode n2 = mid.next;
        mid.next = null;
        ListNode reverse = reverse(n2);
        return merge2Lists(head, reverse);
    }
}
