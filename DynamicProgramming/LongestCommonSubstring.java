public class LongestCommonSubstring {
    int longestCommonSubstr(String s, String t, int n, int m) {
        // code here
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                    res = Math.max(res, curr[j]);
                } else
                    curr[j] = 0;
            }
            prev = curr;
            curr = new int[m + 1];
        }

        return res;
    }
}
