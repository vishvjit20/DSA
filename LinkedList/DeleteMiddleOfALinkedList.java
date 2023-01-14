package LinkedList;

public class DeleteMiddleOfALinkedList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solve(ListNode A) {
        ListNode slow = A, fast = A;
        if (A == null || A.next == null)
            return null;
        if (A.next.next == null) {
            A.next = null;
            return A;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.val = slow.next.val;
        slow.next = slow.next.next;
        return A;
    }
}
