
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
    // Time: O(h)
    // Aux. space: O(h)
    public static Node delete(Node root, int key) {
        if (root == null) {
            return null; // key not found, nothing to delete
        }

        // find the node to delete
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            // Found the node to delete

            // Case 1: no children (leaf)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: one child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // Case 3: two children
            // Find inorder successor (smallest value in right subtree)
            Node successor = findMin(root.right);

            // Copy successor's value into this node
            root.key = successor.key;

            // Delete the successor from the right subtree
            root.right = delete(root.right, successor.key);
        }
        return root;
    }

    // find the smallest node in a subtree (leftmost node)
    public static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = null;

        int[] testKeys = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };
        for (int key : testKeys) {
            root = insert(root, key);
        }

        System.out.print("Before deletion: ");
        inorder(root); // 1 3 4 6 7 8 10 13 14
        System.out.println();

        root = delete(root, 3); // delete node with two children

        System.out.print("After deleting 3: ");
        inorder(root); // 1 4 6 7 8 10 13 14
        System.out.println();

    }

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

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
}