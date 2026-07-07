import java.util.Arrays;

public class Solution {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Initial array: " + Arrays.toString(arr));
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // the element we're inserting into the sorted portion
            int j = i - 1;

            if (arr[j] > key) {
                // Shift elements of the sorted portion that are greater than 'key' one position
                // ahead, to make room for 'key'

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                // Place 'key' in its correct position
                arr[j + 1] = key;
            }

            System.out.println("Pass " + i + " (inserted " + key + "): " + Arrays.toString(arr));

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 9, 4, 7, 1, 2, 6, 5 };

        insertionSort(arr);
    }
}
