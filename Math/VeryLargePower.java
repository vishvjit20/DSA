package Math;

public class VeryLargePower {
    int fact(int n) {
        int p = 1000000006;
        long res = 1l;
        for (int i = n; i >= 1; i--) {
            res = ((long) res * i) % p;
        }

        return (int) res;
    }

    int pow(long a, long b, long c) {

        long res = 1l;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % c;
            }

            a = (a % c * a % c) % c;
            b = b >> 1;
        }
        return (int) (res % c);
    }

    public int solve(int A, int B) {
        int MOD = 1000000007;
        int f = fact(B);
        int res = pow(A, f, MOD);
        return res;
    }
}
