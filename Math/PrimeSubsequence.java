package Math;

import java.util.Arrays;

public class PrimeSubsequence {
    public int solve(int[] A) {
        int max = A[0];
        for (int val : A)
            max = Math.max(val, max);
        boolean[] primes = new boolean[max + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (primes[i] == true) {
                for (int j = i * i; j <= max; j += i) {
                    primes[j] = false;
                }
            }
        }
        int MOD = 1000000007;
        int count = 0;
        for (boolean prime : primes) {
            if (prime == true)
                count++;
        }

        return (int) (Math.pow(2, count) % MOD) - 1;
    }
}
