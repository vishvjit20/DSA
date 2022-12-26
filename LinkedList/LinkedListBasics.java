package LinkedList;

public class LinkedListBasics {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList {
        Node head;
        int size;

        // Search element in a linked list
        boolean search(int k) {
            Node curr = head;
            while (curr != null) {
                if (curr.data == k) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }

        // Insert node at the beginning of a linked list
        void insertAtBeginning(int x) {
            Node node = new Node(x);
            node.next = head;
            head = node;
            size++;
        }

        // Insert at the end of a linked list
        void insertAtEnd(int x) {
            Node curr = head;
            Node node = new Node(x);
            if (curr == null) {
                head = node;
                return;
            }
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
            size++;
        }

        int size() {
            return size;
        }

        // Insert at particular index
        void insertAtIndex(Node head, int idx, int x) {
            Node curr = head;
            Node node = new Node(x);
            int size = size();
            if (idx == 0)
                insertAtBeginning(x);
            else if (idx == size)
                insertAtEnd(x);
            else {

                for (int i = 0; i < idx - 1; i++)
                    curr = curr.next;
                node.next = curr.next;
                curr.next = node;
                size++;
            }
        }

        // Remove node from front
        void removeFront() {
            if (size == 0) {
                return;
            } else if (size == 1) {
                head = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        // Remove Node from back
        void removeEnd() {
            if (size == 0)
                return;
            else if (size == 1) {
                head = null;
                size--;
            } else {
                Node curr = head;
                for (int i = 0; i < size - 2; i++) {
                    curr = curr.next;
                }
                curr.next = null;
                size--;
            }

        }

        // Remove from particular index
        void removeAt(int idx) {
            if (idx < 0 || idx >= size)
                return;
            else if (idx == 0)
                removeFront();
            else if (idx == size - 1)
                removeEnd();
            else {
                Node curr = head;
                for (int i = 0; i < idx - 2; i++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
                size--;
            }
        }
    }

}
