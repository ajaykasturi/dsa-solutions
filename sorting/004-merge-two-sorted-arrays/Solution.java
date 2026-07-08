import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Time: O(m + n) — each element from both arrays is visited exactly once
    // Aux. Space: O(1) - exclude input and output space
    public static List<Integer> mergeSortedArrays(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        int m = a.length, n = b.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                list.add(a[i]);
                i++;
            } else {
                list.add(b[j]);
                j++;
            }
        }
        // At this point, one of the arrays is exhausted.
        // Only ONE of the two loops below will actually run,
        // whichever array still has leftover elements.

        // Copy any remaining elements from 'a'
        while (i < m) {
            list.add(a[i]);
            i++;
        }
        // Copy any remaining elements from 'b'
        while (j < n) {
            list.add(b[j]);
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = { 10, 15, 20 };
        int[] b = { 5, 6, 15 };
        List<Integer> res = mergeSortedArrays(a, b);
        System.out.println(res);
    }
}