class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

@FunctionalInterface
interface InsertFunction {
    Node insert(Node head, int key);
}

public class SortedInsert {

    public static Node sortedInsert1(Node head, int key) {
        Node temp = new Node(key);

        if (head == null) {
            return temp;
        }

        if (key < head.data) {
            temp.next = head;
            return temp;
        }

        Node curr = head;
        while (curr.next != null && curr.next.data < key) {
            curr = curr.next;
        }

        temp.next = curr.next;
        curr.next = temp;

        return head;
    }

    public static Node sortedInsert2(Node head, int key) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node curr = dummy;
        while (curr.next != null && curr.next.data < key) {
            curr = curr.next;
        }

        Node temp = new Node(key);
        temp.next = curr.next;
        curr.next = temp;

        return dummy.next;
    }

    public static void main(String[] args) {
        test(1, SortedInsert::sortedInsert1);

        System.out.println();

        test(2, SortedInsert::sortedInsert2);
    }

    public static void test(int approach, InsertFunction insertFunc) {
        System.out.println("Approach-" + approach);

        Node head = null;

        System.out.println("Original List");
        printListIterative(head);

        head = insertFunc.insert(head, 10);
        printListIterative(head);

        head = insertFunc.insert(head, 15);
        printListIterative(head);

        head = insertFunc.insert(head, 20);
        printListIterative(head);

        head = insertFunc.insert(head, 30);
        printListIterative(head);

        head = insertFunc.insert(head, 25);
        printListIterative(head);

        head = insertFunc.insert(head, 5);
        printListIterative(head);
    }

    public static void printListIterative(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

        System.out.println();
    }
}