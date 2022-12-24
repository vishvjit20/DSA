public class Stairs {
    public int climbStairs(int n) {
        if (n < 2)
            return n;

        int MOD = 1000000007;

        int prev1 = 1, prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = (prev1 % MOD + prev2 % MOD) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
