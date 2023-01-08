public class SubmatrixSumQueries {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int n = A.length;
        int m = A[0].length;
        long prefixSum[][] = new long[n][m];
        prefixSum[0][0] = A[0][0];
        int MOD = 1000000007;

        for (int j = 1; j < m; j++) {
            prefixSum[0][j] = prefixSum[0][j - 1] + A[0][j];
        }
        for (int i = 1; i < n; i++) {
            prefixSum[i][0] = prefixSum[i - 1][0] + A[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prefixSum[i][j] = A[i][j] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1];
            }
        }

        int Q = B.length;
        int res[] = new int[Q];

        for (int i = 0; i < Q; i++) {
            int a1 = B[i] - 1, b1 = C[i] - 1, a2 = D[i] - 1, b2 = E[i] - 1;
            // res[i] = prefixSum[a2][b2] - prefixSum[a1 - 1][b2] - prefixSum[a2][b1 - 1] +
            // prefixSum[a1 - 1][b1 - 1];
            long sum = prefixSum[a2][b2];
            if (a1 > 0)
                sum -= prefixSum[a1 - 1][b2];
            if (b1 > 0)
                sum -= prefixSum[a2][b1 - 1];
            if (a1 > 0 && b1 > 0)
                sum += prefixSum[a1 - 1][b1 - 1];

            sum = sum % MOD;
            if (sum < 0)
                sum += MOD;
            res[i] = (int) sum % MOD;
        }

        return res;
    }
}
