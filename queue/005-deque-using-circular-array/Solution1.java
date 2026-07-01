
class Deque {
    Integer[] arr;
    int size, front, rear, capacity;

    Deque(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new Integer[capacity];
        front = 0;
        rear = capacity - 1;
    }

    // Time: O(1)
    boolean insertFront(int x) {
        if (isFull())
            return false;
        front = (front - 1 + capacity) % capacity; // move backward, first call: (0-1+cap)%cap=cap-1
        arr[front] = x;
        size++;
        return true;
    }

    // Time: O(1)
    boolean insertRear(int x) {
        if (isFull())
            return false;
        rear = (rear + 1) % capacity; // move forward, first call: (-1+1)%cap=0
        arr[rear] = x;
        size++;
        return true;
    }

    // Time: O(1)
    Integer deleteFront() {
        if (isEmpty())
            return null;
        Integer res = arr[front];
        arr[front] = null; // clear stale reference
        front = (front + 1) % capacity; // move forward
        size--;
        return res;
    }

    // Time: O(1)
    Integer deleteRear() {
        if (isEmpty())
            return null;
        Integer res = arr[rear];
        arr[rear] = null;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return res;
    }

    Integer getFront() {
        if (isEmpty())
            return null;
        return arr[front];
    }

    Integer getRear() {
        if (isEmpty())
            return null;
        return arr[rear];
    }

    boolean isFull() {
        return (size == capacity);
    }

    boolean isEmpty() {
        return (size == 0);
    }
}

public class Solution1 {
    public static void main(String[] args) {
        Deque dq = new Deque(5);
        System.out.println(dq.insertFront(10));
        System.out.println(dq.insertFront(20));
        // 20(front) -> 10(rear)
        System.out.println(dq.getFront()); // 20
        System.out.println(dq.getRear()); // 10

        System.out.println(dq.insertRear(30));
        System.out.println(dq.insertRear(40));
        // 30 -> 40(rear) .... 20(front) -> 10
        System.out.println(dq.getFront()); // 20
        System.out.println(dq.getRear()); // 40

        System.out.println(dq.insertFront(50));
        // 30 -> 40(rear) .... 50(front) -> 20 -> 10
        System.out.println(dq.getFront()); // 50
        System.out.println(dq.getRear()); // 40

        System.out.println(dq.insertFront(60));
        System.out.println(dq.getFront()); // 50
        System.out.println(dq.getRear()); // 40
    }
}
