
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
    // Time: O(h)
    // Aux. space: O(1)
    public static Node delete(Node root, int key) {
        Node curr = root;
        Node parent = null;

        // Locate the node to delete (and track its parent)
        while (curr != null && key != curr.key) {
            parent = curr;
            if (key < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        // Key not found
        if (curr == null) {
            return root;
        }

        // Handle node with two children
        // replace with inorder successor, then reduce to a simpler case
        if (curr.left != null && curr.right != null) {
            Node successorParent = curr;
            Node successor = curr.right;

            // Find the leftmost node in curr's right subtree
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Copy successor's value into curr
            curr.key = successor.key;

            // Now we need to delete 'successor' instead
            // it has atmost one child (its right child), so update pointers below
            curr = successor;
            parent = successorParent;
        }

        // Now curr has 0 or 1 child — pick the child (or null)
        Node child = (curr.left != null) ? curr.left : curr.right;

        // Relink parent to skip over curr
        if (parent == null) {
            // curr was the root
            root = child;
        } else if (parent.left == curr) {
            parent.left = child;
        } else {
            parent.right = child;
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