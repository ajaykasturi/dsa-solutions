
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
    // recursive insert in BST
    // Time: O(h) for inserting one key
    // Aux. space: O(h)
    public static Node insert(Node root, int key) {
        // Base case: found the empty spot — create and return new node
        if (root == null) {
            return new Node(key);
        }

        // key belongs in left subtree
        if (key < root.key)
            root.left = insert(root.left, key);
        // key belongs in right subtree
        else if (key > root.key)
            root.right = insert(root.right, key);
        // key == root.data → duplicate, do nothing
        return root;
    }

    public static void main(String[] args) {
        Node root = null;

        int[] testKeys = { 15, 5, 3, 20, 18, 16, 80 };
        for (int key : testKeys) {
            root = insert(root, key);
        }

        for (int key : testKeys) {
            boolean res = search(root, key);
            System.out.println("key: " + key + " -> " + res);
        }
    }

    public static boolean search(Node root, int key) {
        while (root != null) {
            if (key == root.key)
                return true;
            else if (key < root.key)
                root = root.left;
            else
                root = root.right;
        }
        return false;
    }
}