import java.util.Arrays;

public class Solution {
    // Time: O(n^2)
    // Aux. Space: O(1)
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Initial array: " + Arrays.toString(arr));

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            // Find the index of the smallest element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first unsorted element
            if (i != minIndex) {
                swap(arr, i, minIndex);
            }
            System.out.println(
                    "Pass " + (i + 1) + " (placed " + arr[i] + " at index " + i + "): " + Arrays.toString(arr));
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 9, 4, 7, 1, 2, 6, 5 };

        selectionSort(arr);

    }
}
