public class MaximumSumSquareSubmatrix {
    public int solve(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int prefix[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + A[i - 1][j - 1];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int sum = 0;
                if (i - B >= 0 && j - B >= 0) {
                    sum = prefix[i][j] - prefix[i - B][j] - prefix[i][j - B] + prefix[i - B][j - B];
                    res = Math.max(sum, res);
                }
            }
        }

        return res;
    }
}
