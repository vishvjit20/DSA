public class MiminumCoins {
    int minCoins(int coins[], int T) {
        int n = coins.length;
        return f(coins, T, n - 1);
    }

    int f(int coins[], int T, int idx) {
        if (idx == 0) {
            if (T % coins[0] == 0)
                return T / coins[0];
            return Integer.MAX_VALUE;
        }

        int no_take = f(coins, T, idx - 1);
        int take = Integer.MAX_VALUE;
        if (coins[idx] <= T) {
            take = 1 + f(coins, T - coins[idx], idx);
        }

        return Math.min(take, no_take);
    }
}
