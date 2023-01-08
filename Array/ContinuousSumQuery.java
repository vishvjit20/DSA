public class ContinuousSumQuery {
    public int[] solve(int n, int[][] A) {
        int res[] = new int[n];
        for (int row[] : A) {
            int l = row[0] - 1;
            int r = row[1];
            int wt = row[2];
            res[l] += wt;
            if (r < n) {
                res[r] -= wt;
            }
        }
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
