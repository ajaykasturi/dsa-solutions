class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
    }
}

public class Solution {
    // Height of Binary Tree:
    // Maximum number of nodes from root to leaf path
    // Time: O(n)
    // Aux. space: O(h); h=height of binary tree
    public static int height(Node root) {
        if (root == null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
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

        int res = height(root);

        System.out.println(res);

    }
}
