class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front, rear;
    int size;

    Queue() {
        front = rear = null;
        size = 0;
    }

    boolean isEmpty() {
        return (front == null);
    }

    // Time: O(1)
    boolean enque(int x) {
        Node temp = new Node(x);
        size++;
        if (isEmpty()) {
            front = rear = temp;
            return true;
        }
        rear.next = temp;
        rear = temp;
        return true;
    }

    // Time: O(1)
    Integer deque() {
        if (isEmpty()) {
            return null;
        }
        Integer res = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return res;
    }

    Integer getFront() {
        if (isEmpty())
            return null;
        return front.data;
    }

    Integer getRear() {
        if (isEmpty())
            return null;
        return rear.data;
    }
}

public class Solution {
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println("front element: " + q.getFront());
        System.out.println("rear element: " + q.getRear());

        System.out.println("element enqued: " + q.enque(10));
        System.out.println("element enqued: " + q.enque(20));
        System.out.println("element enqued: " + q.enque(30));
        System.out.println("element enqued: " + q.enque(40));

        System.out.println("front element: " + q.getFront());
        System.out.println("rear element: " + q.getRear());

        System.out.println("dequed element: " + q.deque());

        System.out.println("front element: " + q.getFront());
        System.out.println("rear element: " + q.getRear());

        System.out.println("dequed element: " + q.deque());
        System.out.println("dequed element: " + q.deque());
        System.out.println("dequed element: " + q.deque());

        System.out.println("front element: " + q.getFront());
        System.out.println("rear element: " + q.getRear());
    }
}