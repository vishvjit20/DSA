package BinarySearch;

public class AggressiveCows {
    public int solve(int[] A, int B) {
        int n = A.length;
        int left = 1, right = A[n - 1] - A[0];
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

    boolean check(int A[], int B, int tar) {
        int last_placed = A[0];
        int cow = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - last_placed >= tar) {
                last_placed = A[i];
                cow++;
                if (cow == B)
                    return true;
            }
        }
        return false;
    }
}
