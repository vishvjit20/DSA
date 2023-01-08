public class SearchInSortedMatrix {
    public int solve(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;

        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int ele = A[mid / m][mid % m];
            if (ele == B)
                return ((mid / m) + 1) * 1009 + ((mid % m) + 1);
            else if (ele < B) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1;
    }
}
