public class BurstBalloon {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i > j)
                    continue;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = i > 0 ? nums[i - 1] : 1;
                    int right = j < n - 1 ? nums[j + 1] : 1;
                    int cost = left * nums[k] * right + (k > 0 ? dp[i][k - 1] : 0) +
                            (k < n - 1 ? dp[k + 1][j] : 0);
                    if (cost > max)
                        max = cost;
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n - 1];
    }
}
