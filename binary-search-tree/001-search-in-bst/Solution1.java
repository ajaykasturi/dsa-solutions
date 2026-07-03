
class Node {
    int key;
    Node left;
    Node right;

    Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class Solution1 {
    // recursive search in BST
    // Time: O(h)
    // Aux. space: O(h)
    public static boolean search(Node root, int key) {
        if (root == null)
            return false;
        else if (root.key == key)
            return true;
        else if (key < root.key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(15);
        // left subtree
        root.left = new Node(5);
        root.left.left = new Node(3);

        // right subtree
        root.right = new Node(20);
        root.right.left = new Node(18);
        root.right.left.left = new Node(16);
        root.right.right = new Node(80);

        int[] testKeys = { 15, 5, 3, 20, 18, 16, 80, 10, 14, -1 };
        for (int key : testKeys) {
            boolean res = search(root, key);
            System.out.println("key: " + key + " -> " + res);
        }
    }
}