package BitManipulation;

public class DifferentBitsSumPairWise {
    public int cntBits(int[] A) {
        int n = A.length;
        int MOD = 1000000007;
        long res = 0l;
        for (int i = 0; i < 32; i++) {
            long setBits = 0l;
            for (int j = 0; j < n; j++) {
                if (((A[j] >> i) & 1) == 1) {
                    setBits++;
                }
            }

            res = (res + 2 * setBits % MOD * (n - setBits) % MOD) % MOD;
        }
        return (int) res;
    }
}
