public class MinimumSumPath {
    public int minPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int prev[] = new int[m];
        int curr[] = new int[m];

        prev[0] = A[0][0];
        for (int i = 1; i < m; i++) {
            prev[i] = prev[i - 1] + A[0][i];
        }

        for (int i = 1; i < n; i++) {
            curr[0] = prev[0] + A[i][0];
            for (int j = 1; j < m; j++) {
                curr[j] = Math.min(prev[j], curr[j - 1]) + A[i][j];
            }
            prev = curr.clone();
        }

        return prev[m - 1];
    }
}
