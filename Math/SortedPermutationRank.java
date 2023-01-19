public class SortedPermutationRank {
    long fact[] = new long[52];

    public int findRank(String A) {

        int n = A.length();
        int MOD = 1000003;
        fact[0] = 1;
        for (int i = 1; i < 52; i++) {
            fact[i] = (fact[i - 1] % MOD * i % MOD) % MOD;
        }
        long total = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(j) < A.charAt(i)) {
                    count++;
                }
            }
            total += (count * fact[n - i - 1]) % MOD;
        }
        return (int) (total + 1) % MOD;
    }
}
