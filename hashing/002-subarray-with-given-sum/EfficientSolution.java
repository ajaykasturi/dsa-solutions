import java.util.HashSet;
import java.util.Set;

public class EfficientSolution {
    // Time: O(n)
    // Aux Space: O(n)
    public static boolean isSubArraySum(int arr[], int n, int sum) {
        Set<Integer> hs = new HashSet<>();
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum == sum) {
                return true;
            }
            if (hs.contains(prefixSum - sum)) {
                return true;
            }
            hs.add(prefixSum);
        }
        return false;
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