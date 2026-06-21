
public class NaiveSolution {
    // Time: O(n^2)
    // Aux Space: O(1)
    public static int longestSubArrayZerosOnes(int arr[]) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int zerosCount = 0, onesCount = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 0) {
                    zerosCount++;
                } else if (arr[j] == 1) {
                    onesCount++;
                }
                if (zerosCount == onesCount) {
                    res = Math.max(res, zerosCount + onesCount);
                }
            }
        }
        return res;
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
