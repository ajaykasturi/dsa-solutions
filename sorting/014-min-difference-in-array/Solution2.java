import java.util.Arrays;

public class Solution2 {
    // Time: O(nlogn) + O(n) = O(nlogn)
    public static int getMinDifference(int[] arr) {
        Arrays.sort(arr); // sort the array
        int n = arr.length;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            // compute the difference between adjacent elements and take min from it
            res = Math.min(res, Math.abs(arr[i] - arr[i - 1]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 8, 12, 5, 18 };
        int[] arr2 = { 8, 15 };
        int[] arr3 = { 8, -1, 0, 3 };
        int[] arr4 = { 10 };

        test(arr1); // output: 3
        test(arr2); // output: 7
        test(arr3); // output: 1
        test(arr4); // output: INF
    }

    public static void test(int[] arr) {
        int res;
        res = getMinDifference(arr);
        System.out.println(Arrays.toString(arr) + " has min difference=" + res);
    }
}