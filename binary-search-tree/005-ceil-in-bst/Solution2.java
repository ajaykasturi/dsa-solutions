
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
    public static Node ceil(Node root, int x) {
        Node res = null;

        while (root != null) {
            // Exact match — this is the ceil
            if (root.key == x) {
                return root;
            }
            // If root's key is smaller than the given key,
            // ceiling must be in the right subtree (root itself is too small)
            else if (x > root.key) {
                root = root.right;
            }
            // root.key > key: root is a candidate for ceil,
            // but there might be an even closer (smaller) value in the left subtree
            else {
                res = root;
                root = root.left;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Node root = null;

        int[] testKeys = { 50, 30, 70, 20, 40, 60, 80, 55, 65 };
        for (int key : testKeys) {
            root = insert(root, key);
        }

        int x = 58;
        test(root, x);

        x = 35;
        test(root, x);

        x = 10;
        test(root, x);

        x = 30;
        test(root, x);
    }

    public static void test(Node root, int x) {
        Node res = ceil(root, x);
        if (res == null)
            System.out.println("ceil of " + x + " is: " + res);
        else
            System.out.println("ceil of " + x + " is: " + res.key);
    }

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

}