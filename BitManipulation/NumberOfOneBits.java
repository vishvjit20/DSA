package BitManipulation;

public class NumberOfOneBits {
    public int numSetBits(int A) {
        int count = 0;
        while (A > 0) {
            count++;
            A = A & (A - 1);
        }
        return count;
    }
}
