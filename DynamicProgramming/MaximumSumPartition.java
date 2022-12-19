public class MaximumSumPartition {
    int f(int idx, int nums[], int k) {
        if (idx == nums.length)
            return 0;
        int len = 0;
        int max = Integer.MIN_VALUE;
        int max_sum = Integer.MIN_VALUE;
        for (int j = idx; j < Math.min(idx + k, nums.length); j++) {
            len++;
            max = Math.max(max, nums[j]);
            int sum = len * max + f(j + 1, nums, k);
            max_sum = Math.max(max_sum, sum);
        }

        return max_sum;
    }

    int maximuSubarray(int nums[], int k) {
        return f(0, nums, k);
    }
}
