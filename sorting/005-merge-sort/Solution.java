import java.util.Arrays;

public class Solution {
    // merge method complexities
    // Time: O(n)
    // Aux. Space: O(n)
    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1; // size of left half
        int n2 = high - mid; // size of right half

        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy the two halves into separate temp arrays.
        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0; // pointer into 'left'
        int j = 0; // pointer into 'right'
        int k = low; // pointer into 'arr' — where we write the merged result

        // pick the smaller of the two current elements and write it back into arr
        // Runs until one side is exhausted
        // Using <= (not <) keeps the sort 'Stable'
        // if left and right have equal values, the left one (original earlier position)
        // goes first.
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        // Copy any remaining elements from 'left'
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        // Copy any remaining elements from 'right'
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }

    // mergeSort method complexities
    // Time: O(nlogn) - log n levels of recursion, O(n) work merging at each level
    // Aux. Space: O(n) - O(n) from merge()'s temp arrays + O(log n) from the
    // recursion call stack
    public static void mergeSort(int[] arr, int low, int high) {
        // allows if there are atleast two elements
        // 0 or 1 element is trivially already sorted - nothing to do
        if (low < high) {
            int mid = low + (high - low) / 2; // avoids integer overflow vs (low + high) /2
            mergeSort(arr, low, mid); // recursively sort left half
            mergeSort(arr, mid + 1, high); // recursively sort right half
            merge(arr, low, mid, high); // merge the two sorted halves
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 30, 10, 18, 3, 2, 16, 50, 1 };
        test(arr1);

        int[] arr2 = { 10, 5, 30, 15, 5 };
        test(arr2);

        int[] arr3 = { 8, 2, 5, };
        test(arr3);

        int[] arr4 = { 5, 2 };
        test(arr4);

        int[] arr5 = { 5 };
        test(arr5);

        int[] arr6 = {};
        test(arr6);

    }

    // utility method for testing: prints array before and after sorting
    public static void test(int[] arr) {
        System.out.println("Before: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After: " + Arrays.toString(arr));
        System.out.println();
    }
}