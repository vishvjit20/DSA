import java.util.*;

public class ClimbStairs {
    int MOD = 1000000007;

    public int climbStairs(int n) {
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return fn(n, dp);
        int curr = 0, prev1 = 1, prev2 = 1;
        for (int i = 2; i <= n; i++) {
            curr = (prev1 % MOD + prev2 % MOD) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

    }

    // int fn(int n, int dp[]) {
    // if (n == 0)
    // return 1;
    // if (dp[n] != -1)
    // return dp[n];
    // int oneStep = fn(n - 1, dp) % MOD;
    // int twoSteps = 0;
    // if (n > 1)
    // twoSteps = fn(n - 2, dp) % MOD;

    // return dp[n] = (oneStep + twoSteps) % MOD;
    // }
}
