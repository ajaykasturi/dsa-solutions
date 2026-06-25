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
    public static boolean isSorted(Node head) {
        Node curr = head;
        // find first unequal pair
        while (curr != null && curr.next != null) {
            if (curr.data != curr.next.data) {
                break;
            }
            curr = curr.next;
        }
        // all elements are equal
        if (curr.next == null)
            return true;
        boolean increasing = curr.data < curr.next.data;
        while (curr != null && curr.next != null) {
            if (increasing) {
                if (curr.data > curr.next.data)
                    return false;
            } else {
                if (curr.data < curr.next.data)
                    return false;
            }
            curr = curr.next;
        }
        return true;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        printListIterative(head);
        boolean res = isSorted(head);
        System.out.println(res);
    }

    public static void test2() {
        Node head = null;
        head = insertEnd(head, 40);
        head = insertEnd(head, 30);
        head = insertEnd(head, 20);
        head = insertEnd(head, 10);
        printListIterative(head);
        boolean res = isSorted(head);
        System.out.println(res);
    }

    public static void test3() {
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 10);
        head = insertEnd(head, 10);
        head = insertEnd(head, 10);
        printListIterative(head);
        boolean res = isSorted(head);
        System.out.println(res);
    }

    public static void test4() {
        Node head = null;
        head = insertEnd(head, 1);
        head = insertEnd(head, 2);
        head = insertEnd(head, 0);
        head = insertEnd(head, 3);
        printListIterative(head);
        boolean res = isSorted(head);
        System.out.println(res);
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
