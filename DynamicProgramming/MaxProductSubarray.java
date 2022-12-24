public class MaxProductSubarray {
    public int maxProduct(final int[] A) {
        int n = A.length;
        int res = A[0];
        int max = res, min = res;
        for (int i = 1; i < n; i++) {
            if (A[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * A[i], A[i]);
            min = Math.min(min * A[i], A[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
