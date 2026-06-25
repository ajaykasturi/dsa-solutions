class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {
    public static Node deleteNodeAtPosition(Node head, int pos) {

        if (pos <= 0 || head == null) {
            return head;
        }

        if (pos == 1) {
            return head.next;
        }

        Node curr = head;

        for (int i = 1; i <= pos - 2 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null || curr.next == null) {
            return head;
        }

        curr.next = curr.next.next;

        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        printListIterative(head);
        head = deleteNodeAtPosition(head, 3);
        printListIterative(head);
        head = deleteNodeAtPosition(head, 3);
        printListIterative(head);
        head = deleteNodeAtPosition(head, 1);
        printListIterative(head);
        head = deleteNodeAtPosition(head, 1);
        printListIterative(head);
        head = deleteNodeAtPosition(head, 1);
        printListIterative(head);
    }

    public static Node insertEnd(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) { // when llist is empty
            return temp;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    public static void printListIterative(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
