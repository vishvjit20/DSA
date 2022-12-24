public class MaxSumWithoutAdjacent {
    public int adjacent(int[][] A) {
        int n = A[0].length;

        int prev2 = Math.max(A[0][0], A[1][0]);
        if (n == 1)
            return prev2;
        int prev1 = Math.max(prev2, Math.max(A[0][1], A[1][1]));
        for (int i = 2; i < n; i++) {
            int currMax = prev2 + Math.max(A[0][i], A[1][i]);
            int curr = Math.max(currMax, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
