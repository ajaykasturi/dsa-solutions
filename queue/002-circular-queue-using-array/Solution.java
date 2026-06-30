
class Queue {
    Integer[] arr;
    int front, capacity, size;

    Queue(int capacity) {
        this.capacity = capacity;
        arr = new Integer[capacity]; // backing array, fixed size
        size = 0; // number of elements in the queue
        front = 0; // index of the front element

    }

    boolean isFull() {
        return (capacity == size);
    }

    boolean isEmpty() {
        return (size == 0);
    }

    Integer getFront() {
        if (isEmpty())
            return null;
        return arr[front];
    }

    int getRearIndex() {
        int rear = (front + size - 1) % capacity;
        return rear;
    }

    Integer getRear() {
        if (isEmpty())
            return null;
        int rear = getRearIndex();
        return arr[rear];
    }

    // Time: O(1)
    boolean enque(int x) {
        if (isFull())
            return false; // overflow signal, caller decides
        int rear = getRearIndex();
        rear = (rear + 1) % capacity; // move to next slot, wrap if needed
        arr[rear] = x;
        size++;
        return true;
    }

    // Time: O(1)
    Integer deque() {
        if (isEmpty())
            return null;
        Integer res = arr[front];
        arr[front] = null; // clear stale reference, avoid memory leak
        front = (front + 1) % capacity; // advance front, wrap if needed
        size--;
        return res;
    }
}

public class Solution {
    public static void main(String[] args) {
        Queue q = new Queue(3);
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
