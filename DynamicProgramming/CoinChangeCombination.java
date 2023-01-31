import java.util.Arrays;

public class CoinChangeCombination {
    int f(int A[], int tar, int idx, int dp[][]) {
        if (idx < 0)
            return 0;
        if (tar == 0)
            return 1;

        if (dp[idx][tar] != -1) {
            return dp[idx][tar];
        }

        int no_take = f(A, tar, idx - 1, dp) % 1000007;
        int take = 0;
        if (A[idx] <= tar) {
            take = f(A, tar - A[idx], idx, dp) % 1000007;
        }

        return dp[idx][tar] = (take + no_take) % 1000007;
    }

    public int coinchange2(int[] A, int B) {
        int n = A.length;
        int prev[] = new int[B + 1];
        int curr[] = new int[B + 1];

        int MOD = 1000007;
        for (int j = 0; j <= B; j++) {
            if (j % A[0] == 0)
                prev[j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= B; j++) {
                int no_take = prev[j];
                int take = 0;
                if (A[i] <= j) {
                    take = curr[j - A[i]];
                }
                curr[j] = (take + no_take) % MOD;
            }
            prev = curr.clone();
        }
        return prev[B];
    }
}
