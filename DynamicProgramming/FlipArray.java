import java.util.Arrays;

public class FlipArray {
    public int solve(final int[] A) {
        int n = A.length;
        int sum = Arrays.stream(A).sum();

        int t = sum / 2;
        int dp[][] = new int[n][t + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = t; i >= 1; i--) {
            int res = flipArr(A, n - 1, i, dp);
            if (res <= n)
                return res;
        }

        return n + 1;
    }

    int flipArr(int A[], int idx, int sum, int dp[][]) {
        if (sum == 0)
            return 0;
        if (idx == -1) {
            return A.length + 1;
        }

        if (dp[idx][sum] != -1) {
            return dp[idx][sum];
        }

        int no_take = flipArr(A, idx - 1, sum, dp);
        int take = Integer.MAX_VALUE;
        if (sum >= A[idx]) {
            take = flipArr(A, idx - 1, sum - A[idx], dp) + 1;
        }

        return dp[idx][sum] = Math.min(no_take, take);
    }
}
