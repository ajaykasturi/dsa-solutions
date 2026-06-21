import java.util.HashMap;
import java.util.Map;

public class EfficientSolution {
    public static int longestSubArraySum(int arr[], int n, int sum) {
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

    public static int longestSubArrayZerosOnes(int[] arr) {
        // replace 0 with -1 in the array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        int sum = 0;
        int result = longestSubArraySum(arr, n, sum);

        return result;
    }

    public static void main(String[] args) {
        int res;

        int arr1[] = { 1, 0, 1, 1, 1, 0, 0 };
        res = longestSubArrayZerosOnes(arr1);
        System.out.println(res);// 6

        int arr2[] = { 1, 1, 1, 1 };
        res = longestSubArrayZerosOnes(arr2);
        System.out.println(res);// 0

        int arr3[] = { 0, 0, 1, 1, 1, 1, 1 };
        res = longestSubArrayZerosOnes(arr3);
        System.out.println(res);// 4

        int arr4[] = { 0, 0, 1, 0, 1, 1 };
        res = longestSubArrayZerosOnes(arr4);
        System.out.println(res);// 6
    }
}
