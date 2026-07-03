import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
    }
}

public class Solution {
    // Time: O(n)
    // Aux. space: O(h); h=height of binary tree
    public static void inOrder(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    // Time: O(n)
    // Aux. space: O(n)
    public static void preOrder1(Node root) {

        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node curr = st.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null)
                st.push(curr.right);
            if (curr.left != null)
                st.push(curr.left);
        }
    }

    // Time: O(n)
    // Aux. space: O(h)
    public static void preOrder2(Node root) {

        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                System.out.print(curr.data + " ");
                if (curr.right != null)
                    st.push(curr.right);
                curr = curr.left;
            }
            if (!st.isEmpty())
                curr = st.pop();
        }
    }

    // Time: O(n)
    // Aux. space: O(h)
    public static void postOrder(Node root) {
        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        Node lastVisited = null;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                Node peekNode = st.peek();
                // If right child exists and hasn't been processed yet, go right
                if (peekNode.right != null && peekNode.right != lastVisited) {
                    curr = peekNode.right;
                } else {
                    System.out.print(peekNode.data + " ");
                    lastVisited = st.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(10);

        // left subtree
        root.left = new Node(20);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);

        // right subtree
        root.right = new Node(30);
        root.right.right = new Node(60);

        inOrder(root);
        System.out.println();

        preOrder1(root);
        System.out.println();
        preOrder2(root);
        System.out.println();

        postOrder(root);
        System.out.println();

    }
}
