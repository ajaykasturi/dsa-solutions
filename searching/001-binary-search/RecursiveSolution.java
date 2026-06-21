
public class RecursiveSolution {
    // Time: O(logn)
    // Aux Space: O(logn)
    public static int binarySearchRecursive(int[] arr, int low, int high, int x) {
        if (low <= high) {
            // int mid = (low + high) / 2;
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] < x)
                return binarySearchRecursive(arr, mid + 1, high, x);
            else
                return binarySearchRecursive(arr, low, mid - 1, x);
        }
        return -1; // this is executed if low > high
    }

    public static int binarySearch(int[] arr, int x) {
        int n = arr.length;
        return binarySearchRecursive(arr, 0, n - 1, x);
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
