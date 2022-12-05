public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;
        int dp[] = new int[n];
        dp[0] = 1;
        int max_val = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] > nums[j]) {
                    if (max < dp[j]) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            max_val = Math.max(max_val, dp[i]);
        }
        return max_val;
    }
}
