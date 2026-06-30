
class MyStack {
    Integer[] arr;
    int capacity;
    int top;

    MyStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.arr = new Integer[capacity];
    }

    boolean push(int x) {
        if (top == capacity - 1) {
            return false; // Overflow: stack is full
        } else {
            top++;
            arr[top] = x;
            return true;
        }
    }

    Integer pop() {
        if (top == -1) {
            return null; // Underflow: stack is empty"
        }
        Integer res = arr[top];
        arr[top] = null;
        top--;
        return res;
    }

    int size() {
        return (top + 1);
    }

    boolean isEmpty() {
        return (top == -1);
    }

    Integer peek() {
        if (top == -1) {
            return null; // Underflow: stack is empty
        }
        return arr[top];
    }
}

public class Solution {

    public static void main(String[] args) {
        MyStack stack = new MyStack(3);
        System.out.println(stack.isEmpty()); // true
        System.out.println(stack.push(5)); // true
        System.out.println(stack.push(10)); // true
        System.out.println(stack.push(30)); // true
        System.out.println(stack.push(40)); // false
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(40);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}