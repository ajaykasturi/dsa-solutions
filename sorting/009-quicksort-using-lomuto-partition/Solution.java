import java.util.Arrays;

public class Solution {
    // Time: O(n)
    // Aux. space: O(1)
    // Picks the last element as pivot, places it in its correct sorted position,
    // and puts all smaller elements to its left, larger to its right.
    public static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            // found an element smaller than pivot
            if (arr[j] < pivot) {
                i++; // grow the "< pivot" region
                swap(arr, j, i); // move it into that region
            }
        }
        swap(arr, i + 1, high); // place pivot in its correct position
        return (i + 1);
    }

    public static void swap(int[] arr, int i, int j) {
        // skip if same index, nothing to do
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Time: O(n log n) average case, O(n^2) worst case
    // Aux. space: O(log n) average case, O(n) worst case (recursion call stack)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = lomutoPartition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2, 7, 1, 10 };
        int high = arr.length - 1;
        System.out.println("Before: " + Arrays.toString(arr));
        quickSort(arr, 0, high);
        System.out.println("After : " + Arrays.toString(arr));

    }
}
