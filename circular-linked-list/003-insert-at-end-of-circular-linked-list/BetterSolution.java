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
    public static Node insertAtEnd(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            temp.next = temp;
            return temp;
        } else {
            // insert after the head node
            temp.next = head.next;
            head.next = temp;
            // swap data of head and temp
            int x = head.data;
            head.data = temp.data;
            temp.data = x;
            return temp;
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
