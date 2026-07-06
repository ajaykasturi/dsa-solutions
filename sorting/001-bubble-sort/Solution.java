import java.util.Arrays;

public class Solution {

    // Time: O(n^2)
    // Aux. Space: O(1)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // After each pass, the largest unsorted element "bubbles up" to the end
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            // If no swaps happened, array is already sorted — so, stop early
            if (!swapped) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 9, 4, 7, 1, 2, 6, 5 };

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
