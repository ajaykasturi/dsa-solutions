import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    // Time: O((m+n)log(m+n))
    // Aux. space: O(m+n)
    public static List<Integer> unionOfSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;

        int[] temp = new int[m + n];
        // copy elements from both arrays to temp
        for (int i = 0; i < m; i++) {
            temp[i] = a[i];
        }
        for (int i = 0; i < n; i++) {
            temp[m + i] = b[i];
        }

        Arrays.sort(temp); // sort the array

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < m + n; i++) {
            if (i == 0 || temp[i] != temp[i - 1]) { // skip duplicates here
                res.add(temp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // union of two sorted arrays (get every element from both arrays but exactly
        // once)

        int[] a1 = { 3, 5, 8 };
        int[] b1 = { 2, 8, 9, 10, 15 };

        int[] a2 = { 2, 3, 3, 3, 4, 4 };
        int[] b2 = { 4, 4 };

        test(a1, b1); // output: [2, 3, 5, 8, 9, 10, 15]
        test(a2, b2); // output: [2, 3, 4]

    }

    public static void test(int[] a, int[] b) {
        List<Integer> res = unionOfSortedArrays(a, b);
        System.out.println(res);
    }
}
