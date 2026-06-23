
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class NaiveSolution {
    // Time: O(n) + O(n) = O(2n) = O(n)
    // this solution requires two traversals
    public static void findMiddleElement(Node head) {
        if (head == null)
            return;
        int count = 0;
        Node curr;
        for (curr = head; curr != null; curr = curr.next) {
            count++;
        }
        curr = head;
        for (int i = 0; i < count / 2; i++) {
            curr = curr.next;
        }
        System.out.println(curr.data);

    }

    public static void main(String[] args) {
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        head = insertEnd(head, 50);
        printListIterative(head);
        findMiddleElement(head);
        head = insertEnd(head, 60);
        printListIterative(head);
        findMiddleElement(head);
    }

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
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
