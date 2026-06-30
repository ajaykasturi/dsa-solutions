class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Solution {
    // Time: O(1)
    public static Node deleteHead(Node head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return null;
        else {
            head = head.next;
            head.prev = null;
            return head;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 10);
        head = insertAtEnd(head, 20);
        head = insertAtEnd(head, 30);
        head = insertAtEnd(head, 40);
        printList(head);
    }

    public static Node insertAtEnd(Node head, int x) {
        Node temp = new Node(x);
        if (head == null)
            return temp;
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        return head;
    }

    public static void printList(Node head) {
        if (head == null)
            return;
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}