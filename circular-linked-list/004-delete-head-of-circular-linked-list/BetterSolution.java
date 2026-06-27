class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class BetterSolution {
    // Time: O(1);
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
