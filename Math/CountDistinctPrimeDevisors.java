package Math;

import java.util.*;

public class CountDistinctPrimeDevisors {
    public int solve(int[] A) {
        int max = A[0];
        for (int val : A)
            max = Math.max(val, max);
        int spf[] = new int[max + 1];
        for (int i = 0; i <= max; i++)
            spf[i] = i;
        for (int i = 2; i * i <= max; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= max; j += i) {
                    spf[j] = i;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int val : A) {
            int n = val;
            while (n > 1) {
                int x = spf[n];
                while (n % x == 0)
                    n /= x;
                set.add(x);
            }
        }
        return set.size();
    }
}
