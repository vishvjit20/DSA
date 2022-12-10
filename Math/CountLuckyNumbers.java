package Math;

public class CountLuckyNumbers {
    public int solve(int n) {
        int[] spf = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    spf[j] = i;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            int p = spf[i];
            int x = i / p;
            while (x % p == 0)
                x /= p;
            int q = spf[x];
            while (x != 1 && x % q == 0)
                x /= q;
            if (q != 1 && x == 1 && p != q)
                count++;
        }

        return count;
    }
}
