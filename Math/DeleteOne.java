public class DeleteOne {
    public int solve(int[] A) {
        int n = A.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = A[0];
        suff[n - 1] = A[n - 1];
        int res = suff[1];
        for (int i = 1; i < n; i++)
            pre[i] = gcd(pre[i - 1], A[i]);
        for (int i = n - 2; i >= 0; i--)
            suff[i] = gcd(suff[i + 1], A[i]);

        for (int i = 1; i < n; i++) {
            if (i == n - 1)
                res = Math.max(res, pre[i - 1]);
            else
                res = Math.max(res, gcd(pre[i - 1], suff[i + 1]));
        }
        return res;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
