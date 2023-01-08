package BinarySearch;

public class MatrixSearch {
    public int searchMatrix(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int left = 0, right = (n * m) - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int ele = A[mid / m][mid % m];
            if (ele == B)
                return 1;
            if (ele > B)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return 0;
    }
}
