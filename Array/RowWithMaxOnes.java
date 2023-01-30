import java.util.Arrays;

public class RowWithMaxOnes {
    public int solve(int[][] A) {
        int n = A.length;

        int idx = 0, max_sum = 0;

        for (int i = 0; i < n; i++) {
            int sum = Arrays.stream(A[i]).sum();
            if (sum > max_sum) {
                max_sum = sum;
                idx = i;
            }
        }

        return idx;
    }
}
