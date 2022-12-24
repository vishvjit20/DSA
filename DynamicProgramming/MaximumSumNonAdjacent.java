import java.util.Arrays;

public class MaximumSumNonAdjacent {
    public int non_adj_max(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return f(arr, n - 1, dp);
    }

    int f(int arr[], int idx, int[] dp) {
        if (idx == 0)
            return arr[idx];

        if (dp[idx] != -1)
            return dp[idx];

        int take = arr[idx];
        if (idx > 1)
            take += f(arr, idx - 2, dp);
        int no_take = f(arr, idx - 1, dp);

        return dp[idx] = Math.max(take, no_take);
    }
}
