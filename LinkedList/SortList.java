package LinkedList;

public class SortList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode mergeTwoSortedLinkedList(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        ListNode l1 = n1, l2 = n2;
        if (l1 == null)
            return n2;
        if (l2 == null)
            return l1;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                head = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null)
            head.next = l1;
        if (l2 != null)
            head.next = l2;

        return dummy.next;
    }

    ListNode mid(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null)
            return A;
        ListNode mid = mid(A);
        ListNode n = mid.next;
        mid.next = null;
        ListNode n1 = sortList(A);
        ListNode n2 = sortList(n);
        return mergeTwoSortedLinkedList(n1, n2);
    }
}
