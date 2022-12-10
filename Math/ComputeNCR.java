package Math;

public class ComputeNCR {
    // nCr % M
    public int solve(int n, int r, int m) {
        int prev[] = new int[r + 1];
        int curr[] = new int[r + 1];
        prev[0] = curr[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                curr[j] = (prev[j - 1] + prev[j]) % m;
            }
            prev = curr.clone();
        }
        return prev[r];
    }
}
