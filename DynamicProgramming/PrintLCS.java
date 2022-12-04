import java.util.Arrays;

public class PrintLCS {

    public static char[] printLCS(String s, String t) {
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int len = dp[n][m];
        int idx = len - 1;
        int i = n, j = m;
        char res[] = new char[len];
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                res[idx--] = s.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        return res;
    }

    public static void main(String args[]) {
        String s1 = "abcde";
        String s2 = "bdgek";

        char res[] = printLCS(s1, s2);

        System.out.println(Arrays.toString(res));
    }
}
