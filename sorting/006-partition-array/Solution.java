import java.util.Arrays;

public class Solution {
    // Time: O(n)
    // Aux. space: O(n)
    public static void partition(int[] arr, int low, int high, int p) {
        int temp[] = new int[high - low + 1];
        int index = 0;
        // copy elements <= pivot (excluding pivot itself) into temp
        for (int i = low; i <= high; i++) {
            if (i != p && arr[i] <= arr[p]) {
                temp[index] = arr[i];
                index++;
            }
        }
        // place pivot right after the smaller elements
        temp[index] = arr[p];
        index++;

        // copy elements > pivot into temp
        for (int i = low; i <= high; i++) {
            if (arr[i] > arr[p]) {
                temp[index] = arr[i];
                index++;
            }
        }

        // copy temp back into arr, offset by 'low'
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 6, 12, 10, 7 };
        int high = arr.length - 1;
        System.out.println(Arrays.toString(arr));
        partition(arr, 0, high, high); // using the last element as pivot
        System.out.println(Arrays.toString(arr));
    }
}
