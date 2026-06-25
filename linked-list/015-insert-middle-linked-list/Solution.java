class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {
    // Time: O(n)
    // Aux space: O(1)
    public static Node insertMiddle(Node head, int x) {
        if (head == null) {
            return new Node(x);
        }

        Node slow = head;
        Node fast = head;

        // move slow to middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node temp = new Node(x);

        // insert after slow
        temp.next = slow.next;
        slow.next = temp;

        return head;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();

    }

    public static void test1() {
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        printListIterative(head);
        head = insertMiddle(head, 100);
        printListIterative(head);
    }

    public static void test2() {
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        head = insertEnd(head, 50);
        printListIterative(head);
        head = insertMiddle(head, 100);
        printListIterative(head);
    }

    public static void test3() {
        Node head = null;
        printListIterative(head);
        head = insertMiddle(head, 100);
        printListIterative(head);
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
