public class NaiveSolution {
    // Bruteforce solution
    // Time Complexity: O(n^2)
    // Auxiliary Space: O(1)
    public static boolean isSubArraySum(int[] arr, int n, int sum) {
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                if (currentSum == sum) {
                    // printing the subarray with given sum
                    printArray(arr, i, j);
                    return true;
                }

            }
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

    }
}