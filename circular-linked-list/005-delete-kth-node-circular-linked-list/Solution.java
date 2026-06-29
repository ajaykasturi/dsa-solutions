class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {
    // Time: O(n);
    public static Node deleteKthNode(Node head, int k) {
        if (head == null || k <= 0)
            return null;
        if (k == 1)
            return deleteHead(head);
        Node curr = head;
        for (int i = 0; i < k - 2; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static Node deleteHead(Node head) {
        if (head == null)
            return null;
        else if (head.next == head) {
            return null;
        } else {
            head.data = head.next.data;
            head.next = head.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 10);
        head = insertAtEnd(head, 20);
        head = insertAtEnd(head, 30);
        head = insertAtEnd(head, 40);
        head = insertAtEnd(head, 50);
        head = insertAtEnd(head, 60);
        head = insertAtEnd(head, 70);
        head = insertAtEnd(head, 80);
        printList(head);
        head = deleteKthNode(head, 1);
        printList(head);
        head = deleteKthNode(head, 5);
        printList(head);
        head = deleteKthNode(head, 6);
        printList(head);

    }

    public static void printList(Node head) {
        if (head == null)
            return;
        System.out.print(head.data + " ");
        for (Node curr = head.next; curr != head; curr = curr.next) {
            System.out.print(curr.data + " ");
        }
        System.out.println();
    }

    public static Node insertAtEnd(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            temp.next = temp;
            return temp;
        }

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.next = head;
        return head;
    }
}
