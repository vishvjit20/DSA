package Math;

public class APowBModC {
    // Find a ^ b % C
    int pow(int a, int b, int c) {
        if (a == 0)
            return 0;
        if (b == 0)
            return 1;

        long p = (long) pow(a, b / 2, c);
        if (b % 2 == 0)
            return (int) ((p % c * p % c) + c) % c;
        return (int) ((a % c * p % c * p % c) + c) % c;
    }
}
