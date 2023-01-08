public class RainWaterTrap {
    public int trap(final int[] A) {
        int n = A.length;
        int res = 0;
        // for (int i = 1; i < n - 1; i++) {
        // int left = A[i], right = A[i];
        // for (int j = 0; j < i; j++) {
        // left = Math.max(A[j], left);
        // }
        // for (int j = i + 1; j < n; j++) {
        // right = Math.max(A[j], right);
        // }
        // res += Math.min(left, right) - A[i];
        // }

        // return res;
        int pre[] = new int[n];
        int post[] = new int[n];
        pre[0] = A[0];
        post[n - 1] = A[n - 1];
        for (int i = 1; i < n; i++)
            pre[i] = Math.max(pre[i - 1], A[i]);
        for (int i = n - 2; i >= 0; i--)
            post[i] = Math.max(post[i + 1], A[i]);
        for (int i = 0; i < n; i++) {
            res += Math.min(pre[i], post[i]) - A[i];
        }

        return res;
    }
}
