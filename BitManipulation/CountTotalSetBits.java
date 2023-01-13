package BitManipulation;

public class CountTotalSetBits {
    public int solve(int A) {
        if (A <= 1)
            return A;

        int modulo = 0;
        int quotient = 0;
        long res = 0l;
        for (int i = 0; i < 32; i++) {
            if (A < (1 << i))
                break;
            if ((A & (1 << i)) != 0) {
                modulo = A % (1 << i) + 1;
            } else
                modulo = 0;
            quotient = ((A / (1 << (i + 1))) * (1 << i));

            res += (long) modulo + (long) quotient;
        }

        res = res % 1000000007;
        return (int) res;
    }

}
