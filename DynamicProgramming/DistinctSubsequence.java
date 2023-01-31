import java.util.Arrays;

public class DistinctSubsequence {
    String S;
    String T;
    int n1;
    int n2;
    int dp[][];

    public int numDistinct(String S, String T) {
        this.S = S;
        this.T = T;
        n1 = S.length();
        n2 = T.length();
        dp = new int[n1][n2];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, 0);
    }

    int f(int i, int j) {
        if (j == n2)
            return 1;
        if (i >= n1)
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;
        if (S.charAt(i) == T.charAt(j)) {
            res = f(i + 1, j + 1);
        }
        res += f(i + 1, j);
        return dp[i][j] = res;
    }
}
