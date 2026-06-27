class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class NaiveSolution {
    // Time: O(n)
    public static Node insertAtBegin(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
        } else {
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
        }
        return temp;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head, 1);
        head = insertAtBegin(head, 2);
        head = insertAtBegin(head, 3);
        head = insertAtBegin(head, 4);
        head = insertAtBegin(head, 5);
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
}
