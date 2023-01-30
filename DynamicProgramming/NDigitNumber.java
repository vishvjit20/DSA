public class NDigitNumber {
    public int solve(int n, int s) {
        long dp[][] = new long[n + 1][s + 1];
        int MOD = 1000000007;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s; j++) {
                if (i == 1) {
                    dp[i][j] = j <= 9 ? 1 : 0;
                } else {
                    for (int k = 0; k <= 9; k++) {
                        if (j > k)
                            dp[i][j] = (dp[i][j] % MOD + dp[i - 1][j - k] % MOD) % MOD;
                    }
                }
            }
        }

        return (int) dp[n][s];
    }
}
