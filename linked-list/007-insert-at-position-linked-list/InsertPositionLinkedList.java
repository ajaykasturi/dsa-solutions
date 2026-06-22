
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertPositionLinkedList {
    public static Node insertAtPositionApproach1(Node head, int pos, int data) {
        if (pos <= 0)
            return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node curr = dummy;

        int count = 0;
        while (curr != null && count < pos - 1) {
            curr = curr.next;
            count++;
        }

        // curr == null means pos > size + 1, don't insert
        if (curr == null)
            return dummy.next;

        Node temp = new Node(data);
        temp.next = curr.next;
        curr.next = temp;

        return dummy.next;
    }

    public static Node insertAtPositionApproach2(Node head, int pos, int data) {
        if (pos <= 0)
            return head;
        if (pos == 1) {
            Node temp = new Node(data);
            temp.next = head;
            return temp;
        }
        Node curr = head;
        // run pos-2 times to hold of previous node of target position
        for (int i = 1; i <= pos - 2 && curr != null; i++) {
            curr = curr.next;
        }
        if (curr == null) // curr == null means pos > size + 1, don't insert
            return head;

        Node temp = new Node(data);

        temp.next = curr.next;
        curr.next = temp;

        return head;
    }

    public static void main(String[] args) {
        // This is not index based like from 0-n. it is position based
        Node head = null;
        System.out.println("Original LinkedList");
        printListIterative(head);
        // test approach-1
        testApproach1(head);
        // test approach-2
        testApproach2(head);

    }

    public static void testApproach1(Node head) {
        System.out.println("Approach-1");
        // insert if head = null at pos = 2
        head = insertAtPositionApproach1(head, 2, 10);
        System.out.println("After Test Case - 1");
        printListIterative(head); // empty

        // insert if head = null at pos = 1
        head = insertAtPositionApproach1(head, 1, 10);
        System.out.println("After Test Case - 2");
        printListIterative(head); // 10

        // insert if list has only one node
        head = insertAtPositionApproach1(head, 2, 20);
        System.out.println("After Test Case - 3");
        printListIterative(head); // 10, 20

        // insert with position greater than list size + 1
        // now list size = 2,
        // valid positions are pos= 1, 2, 3. invalid are pos=4, 5, 6, ....
        head = insertAtPositionApproach1(head, 4, 30);
        System.out.println("After Test Case - 4"); // 10, 20 there is not change in the list
        printListIterative(head);

        // insert at any position
        head = insertAtPositionApproach1(head, 3, 30);
        System.out.println("After Test Case - 5");
        printListIterative(head); // 10, 20, 30
    }

    public static void testApproach2(Node head) {
        System.out.println("Approach-2");
        // insert if head = null at pos = 2
        head = insertAtPositionApproach2(head, 2, 10);
        System.out.println("After Test Case - 1");
        printListIterative(head); // empty

        // insert if head = null at pos = 1
        head = insertAtPositionApproach2(head, 1, 10);
        System.out.println("After Test Case - 2");
        printListIterative(head); // 10

        // insert if list has only one node
        head = insertAtPositionApproach2(head, 2, 20);
        System.out.println("After Test Case - 3");
        printListIterative(head); // 10, 20

        // insert with position greater than list size + 1
        // now list size = 2,
        // valid positions are pos= 1, 2, 3. invalid are pos=4, 5, 6, ....
        head = insertAtPositionApproach2(head, 4, 30);
        System.out.println("After Test Case - 4"); // 10, 20 there is not change in the list
        printListIterative(head);

        // insert at any position
        head = insertAtPositionApproach2(head, 3, 30);
        System.out.println("After Test Case - 5");
        printListIterative(head); // 10, 20, 30
    }

    // Time: O(n)
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
        if (head == null) {
            System.out.println("list is empty");
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
