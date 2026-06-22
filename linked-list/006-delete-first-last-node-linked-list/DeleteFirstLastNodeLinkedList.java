
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteFirstLastNodeLinkedList {

    // Time: O(1)
    public static Node deleteFirstNode(Node head) {
        if (head == null)
            return null;
        else
            return head.next;
    }

    // Time: O(n)
    public static Node deleteLastNode(Node head) {
        if (head == null) // handles if there is zero node
            return null;
        if (head.next == null) // handles if there is one node
            return null;
        Node curr = head;
        while (curr.next.next != null) { // handles if there are 2 or more nodes
            curr = curr.next;
        }
        curr.next = null;
        return head;

    }

    public static void main(String[] args) {
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        head = insertEnd(head, 50);

        System.out.println("Original LinkedList");
        printListIterative(head);

        head = deleteFirstNode(head);
        System.out.println("After First Node Deletion");
        printListIterative(head);

        head = deleteLastNode(head);
        System.out.println("After Last Node Deletion");
        printListIterative(head);
    }

    // Time: O(n)
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
        if (head == null)
            System.out.println("list is empty");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
