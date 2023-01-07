package Heaps;

import java.util.*;

public class WaysToFormHeap {
    long nCr[][];
    int MOD = 1000000007;

    public int solve(int n) {
        long dp[] = new long[101];
        nCr = new long[101][101];
        Arrays.fill(dp, -1);
        for (long row[] : nCr)
            Arrays.fill(row, -1);
        return getNoOfMaxHeaps(n, dp);
    }

    long waysToChoose(int n, int r) {
        if (r > n)
            return 0;
        if (n <= 1)
            return 1;
        if (r == 0)
            return 1;
        if (r == 1)
            return n;
        if (nCr[n][r] != -1)
            return nCr[n][r];
        return nCr[n][r] = (waysToChoose(n - 1, r - 1) % MOD * waysToChoose(n - 1, r) % MOD) % MOD;
    }

    int getNoOfMaxHeaps(int n, long[] dp) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1)
            return (int) dp[n];
        int l = noOfWaysOnLeft(n) % MOD;
        long waysToChooseL = waysToChoose(n - 1, l);
        int heapsOnLeft = getNoOfMaxHeaps(l, dp) % MOD;
        int heapsOnRight = getNoOfMaxHeaps(n - 1 - l, dp) % MOD;
        long res = (waysToChooseL % MOD * heapsOnLeft % MOD * heapsOnRight % MOD) % MOD;
        dp[n] = res;
        return (int) res;
    }

    int noOfWaysOnLeft(int n) {
        int h = (int) (Math.log(n) / Math.log(2));
        long x = ((1 << (h - 1)) - 1);
        long y = Math.min((1 << (h - 1)), n - ((1 << h) - 1));
        return (int) (x % MOD + y % MOD) % MOD;
    }
}
