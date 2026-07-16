import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    // Time: O(m*n)
    // Aux. Space: O(1)
    public static List<Integer> intersectionOfSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (i > 0 && a[i] == a[i - 1]) // skip duplicates in array 'a'
                continue;
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j]) { // match found in both arrays
                    res.add(a[i]); // add common element to result
                    break; // move to next element in 'a'
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // intersection of two sorted arrays

        int[] a1 = { 3, 5, 10, 10, 10, 15, 15, 20 };
        int[] b1 = { 5, 10, 10, 15, 30 };

        int[] a2 = { 1, 1, 3, 3, 3 };
        int[] b2 = { 1, 1, 1, 1, 3, 5, 7 };

        test(a1, b1); // output: [5, 10, 15]
        test(a2, b2); // output: [1, 3]

    }

    public static void test(int[] a, int[] b) {
        List<Integer> res = intersectionOfSortedArrays(a, b);
        System.out.println(res);
    }
}
