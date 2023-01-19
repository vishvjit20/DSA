
public class ZeroOneKnapSack {
    public int knapsack(int wt[], int val[], int W) {
        int n = wt.length;
        // int dp[][] = new int[n][W + 1];
        // for (int row[] : dp)
        // Arrays.fill(row, -1);
        // return f(wt, val, W, n - 1, dp);
        int prev[] = new int[W + 1];
        int curr[] = new int[W + 1];
        for (int j = wt[0]; j <= W; j++)
            prev[j] = val[0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int no_take = prev[j];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= j) {
                    take = val[i] + prev[j - wt[i]];
                }
                curr[j] = Math.max(no_take, take);
            }
            prev = curr.clone();
        }
        return prev[W];
    }

    int f(int wt[], int val[], int W, int idx, int[][] dp) {
        if (idx == 0) {
            return wt[0] <= W ? val[0] : 0;
        }

        if (dp[idx][W] != -1) {
            return dp[idx][W];
        }

        int no_take = f(wt, val, W, idx - 1, dp);
        int take = Integer.MIN_VALUE;
        if (wt[idx] <= W) {
            take = val[idx] + f(wt, val, W - wt[idx], idx - 1, dp);
        }

        return dp[idx][W] = Math.max(no_take, take);
    }
}
