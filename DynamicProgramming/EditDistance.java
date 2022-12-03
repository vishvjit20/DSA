import java.util.*;

class Solution {
    // private String s1;
    // private String s2;
    // private int dp[][];

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // dp = new int[n + 1][m + 1];
        // for (int row[] : dp)
        // Arrays.fill(row, -1);
        // s1 = word1;
        // s2 = word2;

        // return f(n, m);

        // Tabulation
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];

        for (int j = 0; j <= m; j++)
            prev[j] = j;

        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = Math.min(prev[j], Math.min(prev[j - 1], curr[j - 1])) + 1;
                }
            }
            prev = curr;
            curr = new int[m + 1];
        }

        return prev[m];
    }

    // int f(int i, int j) {
    // if (i < 0)
    // return j + 1;
    // if (j < 0)
    // return i + 1;

    // if (dp[i][j] != -1)
    // return dp[i][j];

    // if (s1.charAt(i - 1) == s2.charAt(j - 1))
    // return dp[i][j] = f(i - 1, j - 1);

    // return dp[i][j] = Math.min(f(i - 1, j), Math.min(f(i, j - 1), f(i - 1, j -
    // 1))) + 1;
    // }
}
