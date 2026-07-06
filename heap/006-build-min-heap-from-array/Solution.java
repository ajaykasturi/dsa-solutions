import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
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

    // Time: O(logn)
    // Aux Space: O(1) — iterative, no recursive call stack
    public void minHeapify(int i) {
        while (true) {
            int leftChild = leftChild(i);

            int rightChild = rightChild(i);

            int smallest = i;

            int size = heap.size();

            if (leftChild < size && heap.get(leftChild) < heap.get(smallest)) {
                smallest = leftChild;
            }
            if (rightChild < size && heap.get(rightChild) < heap.get(smallest)) {
                smallest = rightChild;
            }

            if (smallest == i) {
                break; // heap property restored — nothing more to do
            }

            swap(heap, i, smallest);

            i = smallest; // move down to where it is just swapped, and loop again

        }
    }

    // Time: O(logn) for one element insertion
    // Inserts a new element into the heap (shiftup approach)
    public void insert(int x) {
        heap.add(x);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(parent(i)) > x) {
            swap(heap, parent(i), i);
            i = parent(i);
        }
    }

    // Time: O(log n), Aux Space: O(1) — minHeapify is iterative
    public int extractMin() {
        if (heap.size() == 0)
            return Integer.MAX_VALUE; // heap is empty

        int min = heap.get(0);

        int lastElement = heap.get(heap.size() - 1);

        heap.set(0, lastElement); // move last element to the root

        heap.remove(heap.size() - 1); // remove the now-duplicated last element

        if (heap.size() > 0) {
            minHeapify(0); // shift down from root to restore heap property
        }
        return min;
    }

    // Time: O(logn)
    public void siftUp(int index) {
        while (index > 0 && heap.get(parent(index)) > heap.get(index)) {
            swap(heap, parent(index), index);
            index = parent(index);
        }
    }

    // Approach: Check-Direction (Sift Up OR Down)
    // Time: O(logn)
    public void delete(int index) {
        int size = heap.size();
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }

        int lastElement = heap.get(size - 1);
        heap.set(index, lastElement); // move last element into the deleted slot
        heap.remove(size - 1); // remove the now-duplicated last slot

        // If we just deleted the actual last element, nothing more to do
        if (index == heap.size()) {
            return;
        }

        // Check parent — decide whether to sift UP or sift DOWN
        int parentIndex = parent(index);

        if (index > 0 && heap.get(parentIndex) > heap.get(index)) {
            // Sift Up
            siftUp(index);
        } else {
            // Sift Down
            minHeapify(index);
        }
    }

    // Time: O(n) - NOT O(n log n) [bottom-up heapify, not repeated insert]
    // Aux Space: O(1) — iterative minHeapify, no recursion
    public void buildHeap(int[] arr) {
        heap.clear(); // reset the heap
        for (int val : arr) {
            heap.add(val); // just append — No sift-up here
        }
        // Heapify from the last non-leaf node, down to the root
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public int getMin() {
        return heap.get(0);
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
        MinHeap h = new MinHeap();
        int[] values = { 9, 4, 7, 1, -2, 6, 5 };

        h.buildHeap(values);

        System.out.print("Heap after buildHeap: ");
        h.printHeap();

    }
}