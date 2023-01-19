public class UnboundedKnapsack {

    int unboundedKnapsack(int wt[], int val[], int W) {
        int n = wt.length;
        int prev[] = new int[W + 1];
        int curr[] = new int[W + 1];

        for (int j = 0; j <= W; j++) {
            prev[j] = (j / wt[0]) * val[0];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int no_take = prev[j];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= W) {
                    take = val[i] + curr[j - wt[i]];
                }
                curr[j] = Math.max(no_take, take);
            }
            prev = curr.clone();
        }
        return prev[W];
    }

    // int f(int wt[], int val[], int W, int idx) {
    // if (idx == 0) {
    // return (W / wt[0]) * val[0];
    // }

    // int no_take = f(wt, val, W, idx - 1);
    // int take = Integer.MIN_VALUE;
    // if (wt[idx] <= W) {
    // take = val[idx] + f(wt, val, W - wt[idx], idx);
    // }

    // return Math.max(no_take, take);
    // }
}
