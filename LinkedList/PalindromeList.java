package LinkedList;

import java.util.List;

public class PalindromeList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode mid(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public int lPalin(ListNode A) {
        ListNode mid = mid(A);
        ListNode rev = reverse(mid.next);
        mid.next = null;
        ListNode x = A, y = rev;
        while (x != null && y != null) {
            if (x.val != y.val) {
                return 0;
            }
            x = x.next;
            y = y.next;
        }
        return 1;
    }
}
