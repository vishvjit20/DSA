import java.util.Arrays;

public class Stock2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int dp[][] = new int[n][2];
        // for (int row[] : dp)
        // Arrays.fill(row, -1);
        // return f(prices, 0, 1, dp);

        int next[] = new int[2];
        int curr[] = new int[2];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1)
                    profit = Math.max(-prices[idx] + next[0], next[1]);
                else
                    profit = Math.max(prices[idx] + next[1], next[0]);
                curr[buy] = profit;
            }
            next = curr;
        }
        return next[1];
    }

    int f(int prices[], int idx, int buy, int[][] dp) {
        if (idx == prices.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }
        int profit = 0;

        if (buy == 1) {
            profit = Math.max(-prices[idx] + f(prices, idx + 1, 0, dp), f(prices, idx + 1, buy, dp));
        }

        else {
            profit = Math.max(prices[idx] + f(prices, idx + 1, 1, dp), f(prices, idx + 1, buy, dp));
        }

        return dp[idx][buy] = profit;
    }

}
