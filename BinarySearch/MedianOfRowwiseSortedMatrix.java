package BinarySearch;

public class MedianOfRowwiseSortedMatrix {
    public int findMedian(int[][] A) {
        int n = A.length, m = A[0].length;
        int low = A[0][0], high = A[0][m - 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, A[i][0]);
            high = Math.max(high, A[i][m - 1]);
        }
        int median = (n * m) / 2 + 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += binarySearch(A, i, 0, m - 1, mid);
            }
            if (count < median)
                low = mid + 1;
            else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    int binarySearch(int[][] A, int n, int left, int right, int tar) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[n][mid] <= tar) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return left;
    }
}
