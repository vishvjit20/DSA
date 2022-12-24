
public class MinNoOfSquares {
    public int countMinSquares(int n) {
        int dp[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int res = 1 + dp[i - j * j];
                min = Math.min(res, min);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    // int f(int n, int[] dp) {
    // if (n == 0)
    // return 0;
    // if (dp[n] != -1)
    // return dp[n];
    // int min = Integer.MAX_VALUE;
    // for (int i = 1; i * i <= n; i++) {
    // int res = 1 + f(n - i * i, dp);
    // min = Math.min(res, min);
    // }

    // return dp[n] = min;
    // }
}
