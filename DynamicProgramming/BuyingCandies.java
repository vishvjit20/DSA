
public class BuyingCandies {
    public int solve(int[] A, int[] B, int[] C, int D) {
        int n = A.length;
        int prev[] = new int[D + 1];
        int curr[] = new int[D + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= D; j++) {
                int notake = prev[j];
                int take = Integer.MIN_VALUE;
                if (j >= C[i - 1]) {
                    take = A[i - 1] * B[i - 1] + curr[j - C[i - 1]];
                }

                curr[j] = Math.max(take, notake);
            }

            prev = curr.clone();
        }

        return prev[D];
    }
}
