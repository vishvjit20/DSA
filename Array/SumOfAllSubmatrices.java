public class SumOfAllSubmatrices {
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += A[i][j] * (i + 1) * (j + 1) * (n - i) * (m - j);
            }
        }
        return count;
    }
}
