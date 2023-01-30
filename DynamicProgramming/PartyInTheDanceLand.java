public class PartyInTheDanceLand {
    int f(int n) {
        if (n == 0)
            return 1;
        int alone = f(n - 1);
        int pair = 0;
        if (n > 1)
            pair = (n - 1) * f(n - 2);

        return alone + pair;
    }

    public int solve(int A) {
        return f(A);
    }
}
