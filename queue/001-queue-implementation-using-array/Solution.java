
class Queue {
    int size, capacity;
    Integer[] arr;

    Queue(int capacity) {
        this.capacity = capacity;
        arr = new Integer[capacity];
        size = 0;
    }

    boolean isFull() {
        return (size == capacity);
    }

    boolean isEmpty() {
        return (size == 0);
    }

    // Time: O(1)
    boolean enque(int x) {
        if (isFull())
            return false; // overflow signal, caller decides what to do
        arr[size] = x; // insert at rear (next free slot)
        size++;
        return true;
    }

    // Time: O(n) - every dequeue shifts all elements left
    Integer deque() {
        if (isEmpty())
            return null;
        Integer res = arr[0];
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null; // clear stale reference, avoid memory leak
        size--;
        return res;
    }

    Integer getFront() {
        if (isEmpty())
            return null;
        return arr[0];
    }

    Integer getRear() {
        if (isEmpty())
            return null;
        return arr[size - 1]; // last filled slot, not capacity - 1
    }
}

public class Solution {
    public static void main(String[] args) {
        Queue q = new Queue(3);
        System.out.println(q.getFront());
        System.out.println(q.getRear());
        System.out.println(q.enque(10));
        System.out.println(q.enque(20));
        System.out.println(q.enque(30));
        System.out.println(q.enque(40));
        System.out.println(q.getFront());
        System.out.println(q.getRear());
        q.deque();
        System.out.println(q.getFront());
        System.out.println(q.getRear());
        q.deque();
        q.deque();
        q.deque();
        System.out.println(q.getFront());
        System.out.println(q.getRear());
    }
}