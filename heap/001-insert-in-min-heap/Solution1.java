class MinHeap {
    int[] heap;
    int size;
    int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity]; // Space: O(capacity) — allocated once
        size = 0;
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
        if (size == capacity)
            return;
        size++;
        heap[size - 1] = x;
        int i = size - 1;

        while (i != 0 && heap[parent(i)] > x) {
            swap(heap, parent(i), i);
            i = parent(i);
        }
    }

    public void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

public class Solution1 {
    public static void main(String[] args) {
        MinHeap h = new MinHeap(10);
        int[] values = { 9, 4, 7, 1, -2, 6, 5 };

        // Time: O(nlogn) for n element insertion
        for (int val : values) {
            h.insert(val);
        }

        // Print the heap array
        for (int i = 0; i < h.size; i++) {
            System.out.print(h.heap[i] + " ");
        }
        System.out.println();
    }
}