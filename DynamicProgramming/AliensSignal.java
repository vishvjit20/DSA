public class AliensSignal {
    /*
     * You are trying to send signals to aliens using a linear array of A laser
     * lights.
     * You don't know much about how the aliens are going to percieve the signals,
     * but what you know is that if two consecutive lights are on
     * then the aliens might take it as a sign of danger and destroy the earth.
     * Find and return the total number of ways in which you can send a signal
     * without compromising the safty of the earth. Return the ans % 109 + 7.
     */

    public int solve(int n) {
        if (n <= 1)
            return 1;
        int prev[] = new int[2];
        int curr[] = new int[2];
        int MOD = 1000000007;
        prev[0] = prev[1] = 1;

        for (int i = 1; i < n; i++) {
            curr[0] = (prev[0] % MOD + prev[1] % MOD) % MOD;
            curr[1] = prev[0] % MOD;
            prev = curr.clone();
        }

        return (prev[0] + prev[1]) % MOD;
    }
}
