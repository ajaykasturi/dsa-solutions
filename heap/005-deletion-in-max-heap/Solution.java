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

    // Time: O(logn)
    // Aux Space: O(1) — iterative, no recursive call stack
    public void maxHeapify(int i) {
        while (true) {
            int leftChild = leftChild(i);

            int rightChild = rightChild(i);

            int largest = i;

            int size = heap.size();

            if (leftChild < size && heap.get(leftChild) > heap.get(largest)) {
                largest = leftChild;
            }
            if (rightChild < size && heap.get(rightChild) > heap.get(largest)) {
                largest = rightChild;
            }

            if (largest == i) {
                break; // heap property restored — nothing more to do
            }

            swap(heap, i, largest);

            i = largest; // move down to where it is just swapped, and loop again

        }
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

    // Time: O(log n), Aux Space: O(1) — maxHeapify is iterative
    public int extractMax() {
        if (heap.size() == 0)
            return Integer.MIN_VALUE; // heap is empty

        int max = heap.get(0);

        int lastElement = heap.get(heap.size() - 1);

        heap.set(0, lastElement); // move last element to the root

        heap.remove(heap.size() - 1); // remove the now-duplicated last element

        if (heap.size() > 0) {
            maxHeapify(0); // shift down from root to restore heap property
        }
        return max;
    }

    // Time: O(logn)
    public void siftUp(int index) {
        while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
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

        if (index > 0 && heap.get(parentIndex) < heap.get(index)) {
            // Sift Up
            siftUp(index);
        } else {
            // Sift Down
            maxHeapify(index);
        }

    }

    public int getMax() {
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
        MaxHeap h = new MaxHeap();
        int[] values = { 9, 4, 7, 1, -2, 6, 5 };

        // Build the heap by inserting all values
        for (int val : values) {
            h.insert(val);
        }

        System.out.print("Initial heap: ");
        h.printHeap();

        // Test 1: Delete an element from the middle of the heap
        System.out.println("\nDeleting index 3...");
        h.delete(3);
        System.out.print("Heap after delete(3): ");
        h.printHeap();

        // Test 2: Delete the root (index 0)
        System.out.println("\nDeleting index 0 (root)...");
        h.delete(0);
        System.out.print("Heap after delete(0): ");
        h.printHeap();

        // Test 3: Delete the last element
        int lastIndex = h.heap.size() - 1;
        System.out.println("\nDeleting last index (" + lastIndex + ")...");
        h.delete(lastIndex);
        System.out.print("Heap after delete(last): ");
        h.printHeap();

        // Test 4: Try deleting an invalid index (should throw exception)
        System.out.println("\nTrying to delete invalid index 100...");
        try {
            h.delete(100);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}