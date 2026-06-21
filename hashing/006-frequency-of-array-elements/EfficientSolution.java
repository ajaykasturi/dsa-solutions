import java.util.HashMap;
import java.util.Map;

public class EfficientSolution {
    // Time: O(n)
    // Aux Space: O(n)
    public static Map<Integer, Integer> frequencyCount(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : arr) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        return m;
    }

    public static void printHashMap(Map<Integer, Integer> m) {
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            System.out.println(e.getKey() + "->" + e.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Map<Integer, Integer> m;

        int arr1[] = { 10, 12, 10, 15, 10, 20, 12, 12 };
        m = frequencyCount(arr1);
        printHashMap(m);

        int arr2[] = { 10, 10, 10, 10 };
        m = frequencyCount(arr2);
        printHashMap(m);

        int arr3[] = { 10, 20 };
        m = frequencyCount(arr3);
        printHashMap(m);
    }
}
