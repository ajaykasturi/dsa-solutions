import java.util.HashMap;
import java.util.Map;

public class PrintSubArrayWithGivenSum {
    // Time: O(n)
    // Aux Space: O(n)
    public static boolean isSubArraySum(int arr[], int n, int sum) {
        Map<Integer, Integer> hs = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            if (prefixSum == sum) {
                printArray(arr, 0, i);
                return true;
            }
            if (hs.containsKey(prefixSum - sum)) {
                int startIndex = hs.get(prefixSum - sum) + 1; // +1: subarray starts AFTER that earlier index
                int endIndex = i;
                printArray(arr, startIndex, endIndex);
                return true;
            }
            hs.put(prefixSum, i);
        }
        return false;
    }

    public static void printArray(int arr[], int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean res;
        int sum;

        int[] arr1 = { 5, 8, 6, 13, 3, -1 }; // Expected: true
        sum = 22;
        res = isSubArraySum(arr1, arr1.length, sum);
        System.out.println(res);

        int[] arr2 = { 15, 2, 8, 10, -5, -8, 6 }; // Expected: true
        sum = 3;
        res = isSubArraySum(arr2, arr2.length, sum);
        System.out.println(res);

        int[] arr3 = { 3, 2, 5, 6 }; // Expected: true
        sum = 10;
        res = isSubArraySum(arr3, arr3.length, sum);
        System.out.println(res);

        int[] arr4 = { 2, 3, 4, 6 }; // Expected: true
        sum = 9;
        res = isSubArraySum(arr4, arr4.length, sum);
        System.out.println(res);

    }
}