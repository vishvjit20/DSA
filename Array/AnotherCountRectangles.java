public class AnotherCountRectangles {
    public int solve(int[] A, int B) {
        int l = 0, r = A.length - 1;
        long res = 0;
        int MOD = 1000000007;
        while (l <= r) {
            long area = A[l] * A[r];
            if (area < B) {
                res = res % MOD + (2 * (r - l + 1) % MOD - 1) % MOD;
                l++;
            } else
                r--;
        }

        return (int) (res % MOD);
    }
}
