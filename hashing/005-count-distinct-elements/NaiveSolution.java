
public class NaiveSolution {
    // Time: O(n^2)
    // Aux Space: O(1)
    public static int countDistinct(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res;
        int arr1[] = { 15, 12, 13, 12, 13, 13, 18 };
        res = countDistinct(arr1);
        System.out.println(res);// 4

        int arr2[] = { 10, 10, 10 };
        res = countDistinct(arr2);
        System.out.println(res);// 1

        int arr3[] = { 10, 11, 12 };
        res = countDistinct(arr3);
        System.out.println(res);// 3
    }
}
