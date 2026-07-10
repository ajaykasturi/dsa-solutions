import java.util.Arrays;

public class Solution {
    // Time: O(n)
    // Aux. space: O(1)
    // pivots on arr[low], uses two pointers moving toward each other from both
    // ends, swapping out-of-place pairs until they cross.
    // Unlike Lomuto, the returned index is NOT necessarily the pivot's final sorted
    // position. it's just a valid split point for recursion.
    public static int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low]; // choose first element as pivot

        int i = low - 1; // left pointer, starts just outside range
        int j = high + 1; // right pointer, starts just outside range

        while (true) {
            do {
                i++; // move right until we find element >= pivot
            } while (arr[i] < pivot);
            do {
                j--; // move left until we find element <= pivot
            } while (arr[j] > pivot);
            if (i >= j)
                return j; // pointers crossed — return split index
            swap(arr, i, j);
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

    // Time: O(n log n) average case, O(n^2) worst case (e.g. sorted input with
    // first-element pivot)
    // Aux. space: O(log n) worst case
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = hoarePartition(arr, low, high);

            int leftSize = p - low; // size of [low, p]
            int rightSize = high - (p + 1); // size of [p+1, high]

            if (leftSize < rightSize) {
                quickSort(arr, low, p); // recurse on smaller left
                low = p + 1; // loop into larger right
            } else {
                quickSort(arr, p + 1, high); // recurse on smaller right
                high = p; // loop into larger left
            }
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
