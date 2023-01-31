import java.util.Arrays;

public class MinimumCostToCutTheStick {
    int f(int i, int j, int[] cuts) {
        if (i > j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1] + f(i, k - 1, cuts) + f(k + 1, j, cuts);
            min = Math.min(min, cost);
        }

        return min;
    }

    public int minCost(int c, int[] cuts) {
        Arrays.sort(cuts);
        int n = cuts.length;
        int cutsArr[] = new int[n + 2];
        for (int i = 0; i < n; i++)
            cutsArr[i + 1] = cuts[i];
        cutsArr[n + 1] = c;
        int dp[][] = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    continue;
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = cutsArr[j + 1] - cutsArr[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][n];
    }
}
