package BinarySearch;

public class SpecialInteger {
    public int solve(int[] A, int B) {
        int n = A.length;
        int left = 1, right = n;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(A, B, mid)) {
                res = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return res;
    }

    boolean check(int A[], int B, int mid) {
        long sum = 0;
        int n = A.length;
        for (int i = 0; i < mid; i++)
            sum += A[i];
        if (sum > B)
            return false;
        for (int i = mid; i < n; i++) {
            sum += A[i] - A[i - mid];
            if (sum > B)
                return false;
        }
        return true;
    }
}
