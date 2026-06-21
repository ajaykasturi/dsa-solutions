public class NaiveSolution {
    // Time: O(n^2)
    // Aux. Space: O(1)
    public static int longestSubArraySum(int arr[], int sum) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                if (currentSum == sum) {
                    res = Math.max(res, j - i + 1);
                }
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

    }
}