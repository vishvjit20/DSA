import java.util.Arrays;

public class BooleanExpressionEvaluation {
    int MOD = 1003;

    public int cnttrue(String A) {
        int n = A.length();
        int dp[][][] = new int[n][n][2];
        for (int rows[][] : dp)
            for (int row[] : rows)
                Arrays.fill(row, -1);
        return f(A, 0, n - 1, 1, dp);
    }

    int f(String exp, int i, int j, int isTrue, int[][][] dp) {
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue == 1)
                return exp.charAt(i) == 'T' ? 1 : 0;
            else
                return exp.charAt(i) == 'F' ? 1 : 0;
        }

        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }

        long ways = 0;
        for (int idx = i + 1; idx < j; i += 2) {
            int lt = f(exp, i, idx - 1, 1, dp);
            int lf = f(exp, i, idx - 1, 0, dp);
            int rt = f(exp, idx + 1, j, 1, dp);
            int rf = f(exp, idx + 1, j, 0, dp);

            if (exp.charAt(idx) == '&') {
                if (isTrue == 1)
                    ways += lt * rt;
                else
                    ways += lt * rf + lf * rt + lf * rf;
            } else if (exp.charAt(idx) == '|') {
                if (isTrue == 1)
                    ways += lt * rt + lt * rf + lf * rt;
                else
                    ways += lf * rf;
            } else {
                if (isTrue == 1)
                    ways += lt * rf + lf * rt;
                else
                    ways += lt * rt + lf * rf;
            }
        }

        return dp[i][j][isTrue] = (int) ways % MOD;
    }
}
