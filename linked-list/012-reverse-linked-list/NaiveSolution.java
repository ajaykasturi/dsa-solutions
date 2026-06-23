import java.util.ArrayList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class NaiveSolution {
    // Time: O(n)
    // Aux Space: O(n)
    public static Node reverseListMethod1(Node head) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            arr.add(curr.data);
        }
        for (Node curr = head; curr != null; curr = curr.next) {
            curr.data = arr.remove(arr.size() - 1);
        }
        return head;
    }

    public static Node reverseListMethod2(Node head) {
        Node newHead = null;
        for (Node curr = head; curr != null; curr = curr.next) {
            Node temp = new Node(curr.data);
            temp.next = newHead;
            newHead = temp;
        }
        head = null;
        return newHead;
    }

    public static void main(String[] args) {
        testMethod1();
        testMethod2();
    }

    public static void testMethod1() {
        System.out.println("Method-1");
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        printListIterative(head);
        head = reverseListMethod1(head);
        printListIterative(head);
    }

    public static void testMethod2() {
        System.out.println("Method-2");
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        printListIterative(head);
        head = reverseListMethod2(head);
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
