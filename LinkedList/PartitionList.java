package LinkedList;

public class PartitionList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode A, int B) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode l1 = dummy1, l2 = dummy2;
        ListNode tail = l1;
        while (A != null) {
            if (A.val < B) {
                l1.next = new ListNode(A.val);
                l1 = l1.next;
            } else {
                l2.next = new ListNode(A.val);
                l2 = l2.next;
            }
            A = A.next;
        }
        tail.next = dummy2.next;
        return dummy1.next;
    }
}
