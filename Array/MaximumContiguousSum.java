
public class MaximumContiguousSum {
    public int maxSubArray(final int[] A) {
        int max_sum = Integer.MIN_VALUE,
                curr_sum = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            curr_sum += A[i];
            max_sum = Math.max(max_sum, curr_sum);
            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }
        return max_sum;
    }
}
