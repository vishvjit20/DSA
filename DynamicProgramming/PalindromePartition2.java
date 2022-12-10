import java.util.Arrays;

public class PalindromePartition2 {
    boolean isPalindrome(int i, int j, String str) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public int minCut(String A) {
        int dp[] = new int[A.length()];
        Arrays.fill(dp, -1);
        return partition(A, 0, dp) - 1;
    }

    int partition(String str, int i, int[] dp) {

        if (i == str.length())
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int min = Integer.MAX_VALUE;
        for (int j = i; j < str.length(); j++) {
            if (isPalindrome(i, j, str)) {
                int cost = 1 + partition(str, j + 1, dp);
                min = Math.min(cost, min);
            }
        }

        return dp[i] = min;
    }
}
