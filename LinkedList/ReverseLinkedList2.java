package LinkedList;

public class ReverseLinkedList2 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode nodeBeforeSublist = dummy;
        int pos = 1;
        while (pos < left) {
            pos++;
            nodeBeforeSublist = nodeBeforeSublist.next;
        }
        ListNode workingPtr = nodeBeforeSublist.next;
        while (left < right) {
            ListNode nodeToBeExtracted = workingPtr.next;
            workingPtr.next = nodeToBeExtracted.next;
            nodeToBeExtracted.next = nodeBeforeSublist.next;
            nodeBeforeSublist.next = nodeToBeExtracted;
            left++;
        }

        return dummy.next;
    }
}
