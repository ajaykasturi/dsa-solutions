
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
    // Aux Space: O(1)
    public static void removeDuplicatesFromSorted(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        testMethod1();
    }

    public static void testMethod1() {
        System.out.println("Method-1");
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 30);
        head = insertEnd(head, 30);
        printListIterative(head);
        removeDuplicatesFromSorted(head);
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
