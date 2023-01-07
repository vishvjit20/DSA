package Greedy;

import java.util.Arrays;

public class AssignMiceToHoles {
    public int mice(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.abs(A[i] - B[i]));
        }

        return res;
    }
}
