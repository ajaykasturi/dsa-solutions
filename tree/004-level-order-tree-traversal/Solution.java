import java.util.LinkedList;
import java.util.Queue;

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
    // Aux. space: O(n); h=height of binary tree
    public static void levelOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(10);

        // left subtree
        root.left = new Node(20);

        root.left.left = new Node(8);
        root.left.right = new Node(7);

        root.left.right.left = new Node(9);
        root.left.right.right = new Node(15);

        // right subtree
        root.right = new Node(30);
        root.right.right = new Node(6);

        levelOrderTraversal(root);
        System.out.println();
    }

}
