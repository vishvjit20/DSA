public class ZeroOneKnapsack2 {
    public int solve(int[] value, int[] wt, int W) {
        int n = value.length;
        int prev[] = new int[W + 1];
        int curr[] = new int[W + 1];
        for (int j = wt[0]; j <= W; j++)
            prev[j] = value[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int no_take = prev[j];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= j)
                    take = value[i] + prev[j - wt[i]];
                curr[j] = Math.max(no_take, take);
            }
            prev = curr.clone();
        }
        return prev[W];
    }
}
