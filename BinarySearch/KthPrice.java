package BinarySearch;

public class KthPrice {
    public int solve(final int[] A, int B) {
        int left = 0, right = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            left = Math.min(left, A[i]);
            right = Math.max(right, A[i]);
        }

        int res = 0;

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

    boolean check(int[] A, int k, int tar) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= tar)
                count++;
        }
        return count >= k;
    }
}
