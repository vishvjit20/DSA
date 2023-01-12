package BitManipulation;

public class SingleNumber3 {
    public int[] solve(int[] A) {
        int xor = 0;
        for (int val : A)
            xor ^= val;
        int rightMostSetBit = xor & -xor;
        int a = 0, b = 0;
        for (int val : A) {
            if ((val & rightMostSetBit) == 0)
                a ^= val;
            else
                b ^= val;
        }
        return new int[] { a, b };
    }
}
