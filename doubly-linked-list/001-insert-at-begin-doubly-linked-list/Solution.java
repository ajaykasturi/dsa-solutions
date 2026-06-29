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
    public static Node insertAtBegin(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        if (head != null)
            head.prev = temp;
        return temp;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head, 10);
        head = insertAtBegin(head, 20);
        head = insertAtBegin(head, 30);
        printList(head);
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