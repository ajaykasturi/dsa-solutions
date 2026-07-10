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

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2, 7, 1, 10 };
        int high = arr.length - 1;
        System.out.println(Arrays.toString(arr));
        int res = hoarePartition(arr, 0, high);
        System.out.println(res);
        System.out.println(Arrays.toString(arr));
    }
}
