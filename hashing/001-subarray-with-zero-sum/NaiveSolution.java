public class NaiveSolution {
    // Bruteforce solution
    // Time Complexity: O(n^2)
    // Auxiliary Space: O(1)
    public static boolean isZeroSubArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                if (currentSum == 0)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res;

        int[] arr1 = { 1, 4, 13, -3, -10, 5 }; // Expected: true
        res = isZeroSubArray(arr1, arr1.length);
        System.out.println(res);

        int[] arr2 = { -1, 4, -3, 5, 1 }; // Expected: true
        res = isZeroSubArray(arr2, arr2.length);
        System.out.println(res);

        int[] arr3 = { 3, 1, -2, 5, 6 }; // Expected: false
        res = isZeroSubArray(arr3, arr3.length);
        System.out.println(res);

        int[] arr4 = { 5, 6, 0, 8 }; // Expected: true
        res = isZeroSubArray(arr4, arr4.length);
        System.out.println(res);
    }
}