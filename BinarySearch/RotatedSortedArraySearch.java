package BinarySearch;

public class RotatedSortedArraySearch {
    private int binarySearch(int arr[], int left, int right, int x) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public int search(final int[] A, int B) {
        int n = A.length;
        int left = 0, right = n - 1;
        int pivot = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 0 && A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                pivot = mid;
                break;
            } else if (A[mid] > A[n - 1])
                left = mid + 1;
            else
                right = mid - 1;
        }

        if (B < A[n - 1])
            return binarySearch(A, pivot, n - 1, B);
        return binarySearch(A, 0, pivot - 1, B);

    }
}
