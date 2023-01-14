package LinkedList;

public class RemoveDuplicates {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode prev = A, curr = A;
        while (curr != null) {
            while (prev.val == curr.val) {
                curr = curr.next;
                if (curr == null)
                    break;
            }
            prev.next = curr;
            prev = curr;
            if (curr != null)
                curr = curr.next;
        }
        return A;
    }
}
