package BitManipulation;

public class DifferentBitsSumPairWise {
    public int cntBits(int[] A) {
        int n = A.length;
        long total = 0;
        int MOD = 1000000007;
        for (int i = 0; i < 32; i++) {
            int set = 0;
            for (int val : A) {
                if (((val >> i) & 1) == 1)
                    set++;
            }

            total = (total % MOD + (2 * set % MOD * (n - set) % MOD) % MOD) % MOD;
        }
        return (int) total % MOD;
    }
}
