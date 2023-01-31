public class RodCutting {
    int solve(int A[]) {
        int n = A.length;
        int prev[] = new int[n + 1];
        int curr[] = new int[n + 1];

        for (int j = 1; j <= n; j++)
            prev[j] = A[0] * j;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int no_take = prev[j];
                int take = Integer.MIN_VALUE;
                int currLen = i + 1;
                if (currLen <= j) {
                    take = A[i] + curr[j - currLen];
                }
                curr[j] = Math.max(take, no_take);
            }
            prev = curr.clone();
        }

        return prev[n];
    }
}
