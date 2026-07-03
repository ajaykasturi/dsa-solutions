
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

public class Solution2 {
    // iterative insert in BST
    // Time: O(h) for inserting one key
    // Aux. space: O(1)
    public static Node insert(Node root, int key) {
        Node temp = new Node(key);

        // Case 1: empty tree — new node becomes root
        if (root == null)
            return temp;

        Node parent = null, curr = root;

        while (curr != null) {
            parent = curr;
            if (key < curr.key)
                curr = curr.left;
            else if (key > curr.key)
                curr = curr.right;
            else
                return root; // duplicate key — do nothing, return unchanged tree
        }
        if (key < parent.key)
            parent.left = temp;
        else
            parent.right = temp;

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