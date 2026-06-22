
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SearchLinkedList {
    // Time: O(n)
    // Aux Space: O(1)
    public static int iterativeSearch(Node head, int key) {
        Node curr = head;
        int pos = 0;
        while (curr != null) {
            pos++;
            if (curr.data == key) {
                return pos;
            }
            curr = curr.next;
        }
        return -1;
    }

    // Time: O(n)
    // Aux Space: O(n)
    public static int recursiveSearch(Node head, int key) {
        if (head == null)
            return -1;
        if (head.data == key)
            return 1;
        else {
            int res = recursiveSearch(head.next, key);
            if (res == -1)
                return res;
            else
                return res + 1;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        int res, key;

        // iterative search
        key = 30;
        res = iterativeSearch(head, key);
        System.out.println(res); // 3

        key = 10;
        res = iterativeSearch(head, key);
        System.out.println(res); // 1

        key = 50;
        res = iterativeSearch(head, key);
        System.out.println(res); // -1

        System.out.println();

        // recursive search
        key = 30;
        res = recursiveSearch(head, key);
        System.out.println(res); // 3

        key = 10;
        res = recursiveSearch(head, key);
        System.out.println(res); // 1

        key = 50;
        res = recursiveSearch(head, key);
        System.out.println(res); // -1
    }
}
