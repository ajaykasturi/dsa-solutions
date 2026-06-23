
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Method2 {
    // Time: O(n)
    public static void printNthNode(Node head, int n) {
        if (n <= 0 || head == null)
            return;
        Node first = head;
        for (int i = 0; i < n; i++) {
            if (first == null) // handles if n > length of list
                return;
            first = first.next;
        }
        Node second = head;
        while (first != null) {
            second = second.next;
            first = first.next;
        }

        System.out.printf("node %d is: %d\n", n, second.data);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        System.out.println("test-1");
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        head = insertEnd(head, 50);
        printListIterative(head);
        printNthNode(head, 2);
    }

    public static void test2() {
        System.out.println("test-2");
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        printListIterative(head);
        printNthNode(head, 3);
    }

    public static void test3() {
        System.out.println("test-3");
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        printListIterative(head);
        printNthNode(head, 3);
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
