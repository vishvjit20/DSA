package BitManipulation;

public class SingleNumber2 {
    public int singleNumber(final int[] A) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int setCountBits = 0;
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1)
                    setCountBits++;
                if ((setCountBits % 3) == 0) {
                    count += (1 << i);
                }
            }
        }
        return count;
    }
}
