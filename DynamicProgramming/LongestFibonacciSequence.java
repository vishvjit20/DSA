import java.util.*;

public class LongestFibonacciSequence {
    public int solve(int[] A) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }

        int dp[][] = new int[n][n];
        int maxLen = 0;
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = A[i] - A[j];
                if (map.containsKey(diff) && map.get(diff) < j) {
                    dp[i][j] = Math.max(dp[i][j], dp[j][map.get(diff)] + 1);
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen > 2 ? maxLen + 2 : 0;
    }
}
