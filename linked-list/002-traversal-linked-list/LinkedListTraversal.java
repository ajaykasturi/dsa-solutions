
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListTraversal {
    // Time: O(n)
    // Aux Space: O(1)
    public static void printListIterative(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Time: O(n)
    // Aux Space: O(n)
    public static void printListRecursive(Node head) {
        if (head.next == null)
            return;
        System.out.print(head.data + " ");
        printListIterative(head.next);
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        printListIterative(head);

        printListRecursive(head);

    }
}
