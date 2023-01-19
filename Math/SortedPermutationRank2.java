public class SortedPermutationRank2 {
    public int findRank(String A) {
        int n = A.length();
        int MOD = 1000003;
        int fact[] = new int[n + 1];
        fact[0] = fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(j) < A.charAt(i)) {
                    count++;
                }

            }
            int freq[] = new int[52];
            for (int j = i; j < n; j++) {
                char c = A.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    freq[c - 'a']++;
                } else
                    freq[c - 'a' + 26]++;
            }

            long factVal = 1l;
            for (int j = 0; j < 52; j++) {
                if (freq[j] > 1) {
                    factVal = (factVal * fact[freq[j]]) % MOD;
                }
            }

            long inverse = fermatValue(factVal, MOD - 2, MOD);

            res = (int) ((res % MOD) + ((count * fact[n - i - 1]) % MOD) * inverse % MOD) % MOD;
        }
        return res + 1;
    }

    public int fermatValue(long A, long B, long M) {
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;
        long ans = fermatValue(A, B / 2, M);
        if (B % 2 == 0) {
            return (int) ((ans * ans) % M);
        }
        return (int) (((A % M) * ((ans * ans) % M)) % M);
    }
}
