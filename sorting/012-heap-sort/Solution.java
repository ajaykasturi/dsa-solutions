import java.util.Arrays;

public class Solution {
    // Builds a max-heap from arr, then repeatedly extracts the max element and
    // places it at the end, shrinking the heap by one each time.
    // Time: O(n log n) — always
    // Aux. space: O(1) — sorts in place (excluding O(log n) recursion stack in
    // heapify)
    public static void heapSort(int[] arr) {

        // build max heap
        buildHeap(arr);

        int n = arr.length;

        // repeatedly move current max (root) to the end, shrink heap, re-heapify
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // move current root (max) to end
            heapify(arr, i, 0); // restore heap property on the reduced heap
        }
    }

    public static void buildHeap(int[] arr) {
        int n = arr.length;
        // build max-heap - start from last non-leaf node, heapify each up to root
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void heapify(int[] arr, int n, int i) {

        while (true) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            int largest = i;

            if (leftChild < n && arr[leftChild] > arr[largest]) {
                largest = leftChild;
            }
            if (rightChild < n && arr[rightChild] > arr[largest]) {
                largest = rightChild;
            }

            if (largest == i) {
                break; // heap property satisfied, no more sinking needed
            }

            swap(arr, i, largest);

            i = largest; // move down to the subtree we just swapped into
        }

    }

    public static void swap(int[] arr, int i, int j) {
        // skip if same index, nothing to do
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2, 7, 1, 10 };
        System.out.println("Before: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("After : " + Arrays.toString(arr));
    }
}
