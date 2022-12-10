package Math;

import java.util.Arrays;

public class PrimeNumber {
    static boolean isPrime(int n) {
        // if (n < 2)
        // return false;
        // for (int i = 2; i * i <= n; i++) {
        // if (n % i == 0)
        // return false;
        // }
        // return true;

        // Using sieve algorithm
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
        return primes[n];
    }

    public static void main(String[] args) {
        int n = 17;
        System.out.println(isPrime(n));
        System.out.println('a' > 'Z');
    }
}
