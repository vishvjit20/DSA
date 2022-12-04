public class LongestPalindromicSubsequence {
    public static int solve(String s) {

        String s1 = new String(s);
        String s2 = new StringBuilder(s).reverse().toString();

        return LCS(s1, s2);
    }

    static int LCS(String s, String t) {
        int n = s.length();

        int prev[] = new int[n + 1];
        int curr[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
            curr = new int[n + 1];
        }

        return prev[n];
    }

    public static void main(String args[]) {

        int res = solve("bbabcbcab");
        System.out.println(res);
    }
}
