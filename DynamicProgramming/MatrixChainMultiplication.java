import java.util.Arrays;

public class MatrixChainMultiplication {
    int f(int A[], int i, int j, int[][] dp) {
        if (i == j)
            return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = A[i - 1] * A[k] * A[j] + f(A, i, k, dp) + f(A, k + 1, j, dp);
            min = Math.min(min, steps);
        }

        return dp[i][j] = min;
    }

    public int solve(int[] A) {
        int n = A.length;
        int dp[][] = new int[n][n];
        // for (int row[] : dp) {
        // Arrays.fill(row, -1);
        // }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                if (i == j)
                    dp[i][j] = 0;
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int steps = A[i - 1] * A[k] * A[j] + dp[i][k] + dp[k + 1][j];
                        min = Math.min(min, steps);
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[1][n - 1];
    }
}
