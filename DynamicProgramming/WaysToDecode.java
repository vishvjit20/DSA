import java.util.*;

public class WaysToDecode {
    int MOD = 1000000007;

    int f(String str, int n, int idx, int dp[]) {
        if (idx == n)
            return 1;

        if (dp[idx] != -1) {
            return dp[idx];
        }
        long w1 = 0;
        int d1 = Integer.parseInt(str.substring(idx, idx + 1));
        if (d1 >= 1 && d1 <= 9) {
            w1 = f(str, n, idx + 1, dp);
        }
        long w2 = 0;
        if (idx < n - 1) {
            int d2 = Integer.parseInt(str.substring(idx, idx + 2));
            if (d2 >= 10 && d2 <= 26) {
                w2 = f(str, n, idx + 2, dp);
            }
        }
        int res = (int) (w1 + w2) % MOD;
        return dp[idx] = res;
    }

    public int numDecodings(String A) {
        int n = A.length();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(A, n, 0, dp);
    }
}
