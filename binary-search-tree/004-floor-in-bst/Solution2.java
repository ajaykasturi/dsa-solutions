
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
    public static Node floor(Node root, int x) {
        Node res = null;
        while (root != null) {
            if (root.key == x) {
                return root;
            } else if (x < root.key) {
                root = root.left;
            } else {
                res = root;
                root = root.right;
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
        Node res = floor(root, x);
        if (res == null)
            System.out.println("floor of " + x + " is: " + res);
        else
            System.out.println("floor of " + x + " is: " + res.key);
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