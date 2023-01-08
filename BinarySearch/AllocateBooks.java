package BinarySearch;

public class AllocateBooks {
    public int books(int[] A, int B) {
        int max = 0, sum = 0;
        int n = A.length;
        if (B > n)
            return -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            sum += A[i];
        }
        int res = 0;
        int left = max, right = sum;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(A, B, mid)) {
                res = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return res;
    }

    boolean check(int A[], int B, int tar) {
        int books = 1;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > tar) {
                sum = A[i];
                books++;
            }
        }
        return books <= B;
    }
}
