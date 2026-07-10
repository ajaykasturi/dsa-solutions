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

    public static void main(String[] args) {
        int[] arr = { 3, 8, 6, 12, 10, 7 };
        int high = arr.length - 1;
        System.out.println(Arrays.toString(arr));
        int res = lomutoPartition(arr, 0, high);
        System.out.println(res);
        System.out.println(Arrays.toString(arr));
    }
}
