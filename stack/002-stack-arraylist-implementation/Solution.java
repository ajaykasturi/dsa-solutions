import java.util.ArrayList;

class MyStack {
    ArrayList<Integer> stack;

    MyStack() {
        stack = new ArrayList<>();
    }

    void push(int x) {
        stack.add(x);
    }

    Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    Integer peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }

    int size() {
        return stack.size();
    }

}

public class Solution {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println(stack.isEmpty()); // true
        stack.push(5); // true
        stack.push(10); // true
        stack.push(30); // true
        stack.push(40);
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