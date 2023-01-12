package BitManipulation;

public class SingleNumber {
    public int singleNumber(final int[] A) {
        int res = 0;
        for (int val : A) {
            res ^= val;
        }
        return res;
    }
}
