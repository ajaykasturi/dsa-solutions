
public class NaiveSolution {
    // Time: O(n^2)
    // Aux Space: O(1)
    public static void frequencyCount(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                continue;
            }

            int freq = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    freq++;
                }
            }
            System.out.println(arr[i] + "->" + freq);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int arr1[] = { 10, 12, 10, 15, 10, 20, 12, 12 };
        frequencyCount(arr1);
        int arr2[] = { 10, 10, 10, 10 };
        frequencyCount(arr2);
        int arr3[] = { 10, 20 };
        frequencyCount(arr3);
    }
}
