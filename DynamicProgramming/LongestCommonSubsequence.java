import java.util.Arrays;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        // int dp[][] = new int[n + 1][m + 1];
        // for (int row[] : dp)
        // Arrays.fill(row, -1);
        // return fn(s, t, n, m, dp);
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
            curr = new int[m + 1];
        }

        return prev[m];
    }

    // int fn(String s, String t, int i, int j, int dp[][]) {
    // if (i < 0 || j < 0) {
    // return 0;
    // }
    // if (dp[i][j] != -1) {
    // return dp[i][j];
    // }
    // if (s.charAt(i - 1) == t.charAt(j - 1)) {
    // return dp[i][j] = 1 + fn(s, t, i - 1, j - 1, dp);
    // }

    // return dp[i][j] = Math.max(fn(s, t, i - 1, j, dp), fn(s, t, i, j - 1, dp));
    // }
}
