import java.util.Arrays;

public class FrogJump {
    int frogJumps(int arr[], int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return f(arr, k, n - 1, dp);
    }

    int f(int arr[], int k, int idx, int dp[]) {
        if (idx == 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int min_steps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (idx - j >= 0) {
                int jump = Math.abs(arr[idx] - arr[idx - j]) + f(arr, k, idx - j, dp);
                min_steps = Math.min(min_steps, jump);
            }
        }

        return dp[idx] = min_steps;
    }
}
