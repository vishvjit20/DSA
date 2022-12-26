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
        int count = k;
        ListNode curr = head, prev = null, currNext = null;
        while (curr != null && count > 0) {
            currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
            count--;
        }
        head.next = reverseInKGroup(curr, k);
        return prev;
    }
}
