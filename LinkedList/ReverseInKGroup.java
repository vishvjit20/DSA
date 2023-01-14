package LinkedList;

public class ReverseInKGroup {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseInKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        if (head == null || head.next == null) {
            return head;
        }
        int count = k;
        ListNode prev = null, curr = head;
        while (curr != null && count-- > 0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head.next = reverseInKGroup(curr, k);
        return prev;
    }
}
