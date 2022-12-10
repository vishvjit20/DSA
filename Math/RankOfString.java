package Math;

public class RankOfString {
    public int findRank(String A) {
        int n = A.length();
        int MOD = 1000003;
        int res = 0;
        int fact[] = new int[n + 1];
        fact[0] = fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            // for calculating how many characters are smaller than current character
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(i) > A.charAt(j))
                    cnt++;
            }
            // calculating the Frequency of repeted characters including current character
            int freq[] = new int[52];
            for (int j = i; j < n; j++) {
                char c = A.charAt(j);
                if (c <= 'z' && c >= 'a') {
                    freq[c - 'a']++;
                } else
                    freq[c - 'A' + 26]++;
            }
            // Finding the Factorial of duplicate value simulteneously multiplying them
            long factVal = 1;
            for (int j = 0; j < 52; j++) {
                if (freq[j] > 1) {
                    factVal = (factVal * fact[freq[j]]) % MOD;
                }
            }
            // calculating the value of (1 / factorial) % mod using fermats little theorem
            long inverse = fermatsVal(factVal, MOD - 2, MOD);

            res = (int) ((res % MOD) + (((cnt * fact[n - i - 1]) % MOD) * inverse % MOD) % MOD);
        }
        return res + 1;
    }

    public int fermatsVal(long A, long B, long M) {
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;
        long ans = fermatsVal(A, B / 2, M);
        if (B % 2 == 0) {
            return (int) ((ans * ans) % M);
        }
        return (int) (((A % M) * ((ans * ans) % M)) % M);
    }
}
