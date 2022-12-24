public class MaximumSumValue {
    public int solve(int[] A, int B, int C, int D) {
        // find max A[i] * B + A[j] * C + A[k] * D 1 <= i <= j <= k <= N
        int n = A.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = A[0] * B;
        right[n - 1] = A[n - 1] * D;
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], A[i] * B);
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], A[i] * D);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(left[i] + right[i] + A[i] * C, res);
        }
        return res;
    }
}
