package LinkedList;

public class ReverseALinkedList {
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

    // public ListNode reverseList(ListNode head) {
    // ListNode curr = head, prev = null;
    // while (curr != null) {
    // ListNode next = curr.next;
    // curr.next = prev;
    // prev = curr;
    // curr = next;
    // if (next != null)
    // next = next.next;
    // }
    // head = prev;
    // return head;
    // }

    // Reverse LinkedList using recursion
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }

}
