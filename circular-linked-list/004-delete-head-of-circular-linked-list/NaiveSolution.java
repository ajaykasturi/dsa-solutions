class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class NaiveSolution {
    // Time: O(n);
    public static Node deleteHead(Node head) {
        if (head == null)
            return null;
        if (head.next == head) {
            return null;
        }
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = head.next;
        return curr.next;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);
        printList(head);
        head = deleteHead(head);
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
