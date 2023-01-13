package BitManipulation;

public class SmallestXOR {
    public int solve(int A, int B) {
        int x = 0;

        for (int i = 31; i >= 0; i--) {
            if (B == 0)
                return x;
            if (((1 << i) & A) != 0) {
                x |= (1 << i);
                B--;
            }
        }
        if (B == 0)
            return x;
        for (int i = 0; i < 32; i++) {
            if (B == 0)
                return x;
            if (((1 << i) & x) == 0) {
                x = x | (1 << i);
                B--;
            }
        }

        return x;
    }
}
