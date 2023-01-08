package BinarySearch;

public class AthMagicalNumber {
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int solve(int A, int B, int C) {
        int min = Math.min(B, C);
        long low = min, high = (long) A * min;

        if (A == 1)
            return (int) low;
        long res = 0;
        int MOD = 1000000007;
        long lcm = (long) B * C / gcd(B, C);
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long countB = mid / B;
            long countC = mid / C;

            long cf = countB + countC - (mid / lcm);

            if (cf >= A) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        if (res < 0)
            res += MOD;

        return (int) (res % MOD);
    }
}
