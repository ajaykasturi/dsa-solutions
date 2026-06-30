class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

// Time: O(1) for all operations
class MyStack {
    Node head;
    int size;

    MyStack() {
        head = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }

    Integer pop() {
        if (head == null) {
            return null; // underflow: stack is empty
        }
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }

    Integer peek() {
        if (head == null) {
            return null; // underflow: stack is empty
        }
        return head.data;
    }

}

public class Solution {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.peek());
    }
}