package BitManipulation;

import java.util.Arrays;

public class MinimumXORPair {
    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int min = A[0] ^ A[1];
        for (int i = 2; i < A.length; i++) {
            int xor = A[i - 1] ^ A[i];
            if (xor < min) {
                min = xor;
            }
        }
        return min;
    }
}
