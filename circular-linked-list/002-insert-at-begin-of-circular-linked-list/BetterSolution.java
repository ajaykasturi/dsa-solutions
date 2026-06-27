class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class BetterSolution {
    // Time: O(1)
    public static Node insertAtBegin(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        } else {
            // inserting temp after head;
            temp.next = head.next;
            head.next = temp;
            // swap data of head and temp;
            int data = head.data;
            head.data = temp.data;
            temp.data = data;
            return head;
        }
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
