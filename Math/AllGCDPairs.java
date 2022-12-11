public class AllGCDPairs {
    public int[] solve(int[] A) {
        int n = (int) Math.sqrt(A.length);

        int res[] = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (; j < (i + 1) * n; j++) {
                max = Math.max(max, A[j]);
            }

            res[i] = max;
        }

        return res;
    }
}
