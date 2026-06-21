import java.util.HashMap;
import java.util.Map;

public class EfficientSolution {
    // Time: O(n)
    // Aux. Space: O(n)
    public static int longestSubArraySum(int arr[], int sum) {
        int n = arr.length;
        Map<Integer, Integer> m = new HashMap<>();
        int prefixSum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum == sum) {
                // this condition exists because, initially there is no prefixSum before 0-index
                res = i + 1;
            }
            // if prefixSum already exists, just ignore it to keep old entry
            // old entry is used to get longest length
            if (m.containsKey(prefixSum) == false) {
                m.put(prefixSum, i);
            }
            int targetSum = prefixSum - sum;
            if (m.containsKey(targetSum)) {
                res = Math.max(res, i - m.get(targetSum));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int sum, res;

        int arr1[] = { 5, 8, -4, -4, 9, -2, 2 };
        sum = 0;
        res = longestSubArraySum(arr1, sum);
        System.out.println(res); // 3

        int arr2[] = { 3, 1, 0, 1, 8, 2, 3, 6 };
        sum = 5;
        res = longestSubArraySum(arr2, sum);
        System.out.println(res); // 4

        int arr3[] = { 8, 3, 7 };
        sum = 15;
        res = longestSubArraySum(arr3, sum);
        System.out.println(res); // 0

        int arr4[] = { 8, 3, 1, 5, -6, 6, 2, 2 };
        sum = 4;
        res = longestSubArraySum(arr4, sum);
        System.out.println(res); // 4

    }
}
