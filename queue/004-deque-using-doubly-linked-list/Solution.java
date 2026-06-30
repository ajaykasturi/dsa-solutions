
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Deque {
    Node front, rear;
    int size = 0;

    Deque() {
        front = rear = null;
    }

    boolean insertFront(int x) {
        Node temp = new Node(x);
        if (isEmpty()) {
            front = rear = temp; // first node — front and rear are the same
        } else {
            temp.next = front;
            front.prev = temp;
            front = temp;
        }
        size++;
        return true;
    }

    boolean insertRear(int x) {
        Node temp = new Node(x);
        if (isEmpty()) {
            front = rear = temp; // first node — front and rear are the same
        } else {
            rear.next = temp;
            temp.prev = rear;
            rear = temp;
        }
        size++;
        return true;
    }

    Integer deleteFront() {
        if (isEmpty()) {
            return null;
        }
        Integer res = front.data;
        front = front.next; // move front forward
        if (front == null) {
            rear = null; // queue is now empty, reset rear too
        } else {
            front.prev = null; // clear stale backward pointer
        }
        size--;
        return res;
    }

    Integer deleteRear() {
        if (isEmpty()) {
            return null;
        }
        Integer res = rear.data;
        rear = rear.prev; // move rear backward
        if (rear == null) {
            front = null; // queue is now empty, reset front too
        } else {
            rear.next = null; // clear stale forward pointer
        }
        size--;
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

    boolean isEmpty() {
        return (front == null && rear == null);
    }

    int getSize() {
        return size;
    }
}

public class Solution {
    public static void main(String[] args) {
        Deque dq = new Deque();

        System.out.println(dq.getFront()); // null

        dq.insertFront(10);
        dq.insertFront(20);
        // 20 -> 10
        System.out.println(dq.getFront()); // 20
        System.out.println(dq.getRear()); // 10

        dq.insertRear(30);
        dq.insertRear(40);

        // 20 -> 10 -> 30 -> 40
        System.out.println(dq.getFront()); // 20
        System.out.println(dq.getRear()); // 40

        dq.insertFront(50);

        // 50 -> 20 -> 10 -> 30 -> 40
        System.out.println(dq.getFront()); // 50
        System.out.println(dq.getRear()); // 40
    }
}
