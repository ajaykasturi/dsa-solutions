import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    // Time: O(m+n)
    public static List<Integer> unionOfSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;

        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0;

        while (i < m && j < n) { // keep going until one array runs out
            if (i > 0 && a[i] == a[i - 1]) { // current element in 'a' already seen, skip it
                i++;
                continue;
            }
            if (j > 0 && b[j] == b[j - 1]) { // current element in 'b' already seen, skip it
                j++;
                continue;
            }
            if (a[i] < b[j]) { // a's element is smaller, pick it and move 'a' forward
                res.add(a[i]);
                i++;
            } else if (a[i] > b[j]) { // b's element is smaller, pick it and move 'b' forward
                res.add(b[j]);
                j++;
            } else { // both are equal, pick one and move both pointers forward
                res.add(a[i]);
                i++;
                j++;
            }
        }
        // pick up any leftover elements in a
        while (i < m) {
            if (i > 0 && a[i] == a[i - 1]) { // skip leftover duplicates in 'a'
                i++;
                continue;
            }
            res.add(a[i]);
            i++;
        }
        // pick up any leftover elements in b
        while (j < n) {
            if (j > 0 && b[j] == b[j - 1]) { // skip leftover duplicates in 'b'
                j++;
                continue;
            }
            res.add(b[j]);
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        // union of two sorted arrays (get every element from both arrays but exactly
        // once)

        int[] a1 = { 3, 5, 8 };
        int[] b1 = { 2, 8, 9, 10, 15, 15 };

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
