class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertBeginLinkedList {
    // Time: O(1)
    public static Node insertBegin(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        return temp;
    }

    public static void printListIterative(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertBegin(head, 10);
        head = insertBegin(head, 20);
        head = insertBegin(head, 30);

        printListIterative(head);
    }
}
