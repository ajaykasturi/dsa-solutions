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
    public static void printKLevelNodes(Node root, int k) {
        if (root == null)
            return;
        else if (k == 0)
            System.out.print(root.data + " ");
        else {
            printKLevelNodes(root.left, k - 1);
            printKLevelNodes(root.right, k - 1);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(10);

        // left subtree
        root.left = new Node(20);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        // right subtree
        root.right = new Node(30);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);

        int k = 0;
        System.out.print("k=" + k + ": ");
        printKLevelNodes(root, k);
        System.out.println();

        k = 1;
        printNodesTest(root, k);

        k = 2;
        printNodesTest(root, k);

        k = 3;
        printNodesTest(root, k);

        k = 4;
        printNodesTest(root, k);

        k = -1;
        printNodesTest(root, k);
    }

    public static void printNodesTest(Node root, int k) {
        System.out.print("k=" + k + ": ");
        printKLevelNodes(root, k);
        System.out.println();
    }
}
