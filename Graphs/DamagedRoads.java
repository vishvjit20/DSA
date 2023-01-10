import java.util.Arrays;

public class DamagedRoads {
    class Pair {
        int wt;
        boolean isVertical;

        public Pair(int wt, boolean isVertical) {
            this.wt = wt;
            this.isVertical = isVertical;
        }
    }

    int solve(int A[], int B[]) {

        int n = A.length, m = B.length;
        int MOD = 1000000007;
        Pair[] pairs = new Pair[n + m];
        for (int i = 0; i < n; i++)
            pairs[i] = new Pair(A[i], true);
        for (int i = n; i < n + m; i++)
            pairs[i] = new Pair(B[i - n], false);
        Arrays.sort(pairs, (a, b) -> a.wt - b.wt);
        n++;
        m++;
        int i = 0;
        long cost = 0l;
        int count = (n * m) - 1; // Minimum edges to connect n * m cities
        while (count > 0) {
            Pair p = pairs[i];
            if (p.isVertical) {
                cost = (cost + m * p.wt) % MOD;
                count -= m;
                n--;
            } else {
                cost = (cost + n * p.wt) % MOD;
                count -= n;
                m--;
            }
            i++;
        }
        return (int) cost;
    }
}
