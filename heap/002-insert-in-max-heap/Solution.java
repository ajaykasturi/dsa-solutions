import java.util.ArrayList;

class MaxHeap {
    ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>(); // Output Space: O(n)
    }

    // Returns index of left child of node at index i
    public int leftChild(int i) {
        return (2 * i + 1);
    }

    // Returns index of right child of node at index i
    public int rightChild(int i) {
        return (2 * i + 2);
    }

    // Returns index of parent of node at index i
    public int parent(int i) {
        return (i - 1) / 2;
    }

    // Time: O(logn) for one element insertion
    // Inserts a new element into the heap (shiftup approach)
    public void insert(int x) {
        heap.add(x);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(parent(i)) < x) {
            swap(heap, parent(i), i);
            i = parent(i);
        }
    }

    public void swap(ArrayList<Integer> heap, int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printHeap() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Solution {
    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
        int[] values = { 9, 4, 7, 1, -2, 6, 5 };

        // Time: O(nlogn) for n element insertion
        for (int val : values) {
            h.insert(val);
            h.printHeap(); // print after shiftup
        }
    }
}