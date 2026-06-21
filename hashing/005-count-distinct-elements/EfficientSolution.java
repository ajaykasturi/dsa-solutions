import java.util.HashSet;
import java.util.Set;

public class EfficientSolution {
    // Time: O(n)
    // Aux Space: O(n)
    public static int countDistinct(int[] arr) {
        int n = arr.length;
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(arr[i]);
        }
        return hs.size();
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
