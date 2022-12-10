package Math;

import java.util.Arrays;

public class PrimeSum {
    public int[] primesum(int n) {
        boolean primes[] = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (primes[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        int i = 2, j = n - 2;
        while (i < j) {
            if (primes[i] == true && primes[j] == true) {
                return new int[] { i, j };
            }
            i++;
            j--;
        }

        return new int[] { 2, n - 2 };
    }
}
