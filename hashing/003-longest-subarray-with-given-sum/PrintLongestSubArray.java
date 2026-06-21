
import java.util.HashMap;
import java.util.Map;

public class PrintLongestSubArray {
    // Time: O(n)
    // Aux. Space: O(n)
    public static int longestSubArraySum(int arr[], int sum) {
        int n = arr.length;
        Map<Integer, Integer> m = new HashMap<>();
        int prefixSum = 0;
        int res = 0;

        // used to hold start and end indices
        int start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum == sum) {
                // this condition exists because, initially there is no prefixSum before 0-index
                res = i + 1;
                start = 0;
                end = i;

            }
            // if prefixSum already exists, just ignore it to keep old entry
            // old entry is used to get longest length
            if (m.containsKey(prefixSum) == false) {
                m.put(prefixSum, i);
            }
            int targetSum = prefixSum - sum;
            if (m.containsKey(targetSum)) {
                int temp = res;
                res = Math.max(res, i - m.get(targetSum));
                if (res != temp) {
                    start = m.get(targetSum) + 1;
                    end = i;
                }
            }
        }
        if (start != -1 && end != -1) {
            printArray(arr, start, end);
        }
        return res;
    }

    public static void printArray(int[] arr, int start, int end) {
        System.out.print("Array: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int sum, res;

        int arr1[] = { 5, 8, -4, -4, 9, -2, 2 };
        sum = 0;
        res = longestSubArraySum(arr1, sum);
        System.out.println("; Answer: " + res); // 3

        int arr2[] = { 3, 1, 0, 1, 8, 2, 3, 6 };
        sum = 5;
        res = longestSubArraySum(arr2, sum);
        System.out.println("; Answer: " + res); // 4

        int arr3[] = { 8, 3, 7 };
        sum = 15;
        res = longestSubArraySum(arr3, sum);
        System.out.println("; Answer: " + res); // 0

        int arr4[] = { 8, 3, 1, 5, -6, 6, 2, 2 };
        sum = 4;
        res = longestSubArraySum(arr4, sum);
        System.out.println("; Answer: " + res); // 4

    }
}
