package BinarySearch;

public class FindPeakElement {
    public int solve(int[] A) {
        int n = A.length;
        if (n == 1)
            return A[0];
        if (A[0] > A[1])
            return A[0];
        if (A[n - 1] > A[n - 2])
            return A[n - 1];
        int left = 1, right = n - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1]) {
                return A[mid];
            } else if (A[mid] < A[mid - 1])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
