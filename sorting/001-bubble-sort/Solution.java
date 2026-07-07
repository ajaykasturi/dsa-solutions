import java.util.Arrays;

public class Solution {

    // Time: O(n^2)
    // Aux. Space: O(1)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        System.out.println("Initial array: " + Arrays.toString(arr));

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // After each pass, the largest unsorted element "bubbles up" to the end
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                    System.out.println("  Swapped indices " + j + " and " + (j + 1) + ": " + Arrays.toString(arr));
                }
            }
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(arr));
            // If no swaps happened, array is already sorted — so, stop early
            if (!swapped) {
                System.out.println("No swaps in this pass — array is sorted. Stopping early.");
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
    }
}
