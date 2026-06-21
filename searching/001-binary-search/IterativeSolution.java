
public class IterativeSolution {
    // Time: O(logn)
    // Aux Space: O(1)
    public static int binarySearch(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // Check if x is present at mid
            if (arr[mid] == x) {
                return mid;
            }
            // If x is smaller, ignore right half
            else if (arr[mid] > x) {
                high = mid - 1;
            }
            // If x greater, ignore left half
            else {
                low = low + 1;
            }
        }
        // If we reach here, then element was not present
        return -1;
    }

    public static void main(String[] args) {
        int x;
        int res;
        int arr1[] = { 10, 20, 30, 40, 50, 60 };
        x = 20;
        res = binarySearch(arr1, x);
        System.out.println(res);// 1

        int arr2[] = { 5, 15, 25 };
        x = 25;
        res = binarySearch(arr2, x);
        System.out.println(res);// 2

        int arr3[] = { 5, 10, 15, 25, 35 };
        x = 20;
        res = binarySearch(arr3, x);
        System.out.println(res);// -1

        int arr4[] = { 10, 15 };
        x = 20;
        res = binarySearch(arr4, x);
        System.out.println(res);// -1

        x = 5;
        res = binarySearch(arr4, x);
        System.out.println(res);// -1

        int arr5[] = { 10, 10 };
        x = 10;
        res = binarySearch(arr5, x);
        System.out.println(res);// 0 or 1
    }
}
