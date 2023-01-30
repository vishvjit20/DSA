import java.util.Arrays;

public class UniquePathsInAGrid {
    // int f(int A[][], int x1, int y1, int x2, int y2, int[][] dp) {
    // if (x1 > x2 || y1 > y2 || A[x1][y1] == 1) {
    // return 0;
    // }
    // if (x1 == x2 && y1 == y2) {
    // return 1;
    // }
    // if (dp[x1][y1] != -1) {
    // return dp[x1][y1];
    // }
    // A[x1][y1] = 1;
    // int right = f(A, x1, y1 + 1, x2, y2, dp);
    // int down = f(A, x1 + 1, y1, x2, y2, dp);
    // A[x1][y1] = 0;
    // return dp[x1][y1] = right + down;

    // }

    public static int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        if (A[0][0] == 1 || A[n - 1][m - 1] == 1) {
            return 0;
        }

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1)
                    dp[i][j] = 1;
                else if (A[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else
                    dp[i][j] = 0;
            }
        }

        return dp[n][m];
        // for (int row[] : dp)
        // Arrays.fill(row, -1);

        // return f(A, 0, 0, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        int A[][] = {
                { 0, 0 },
                { 0, 0 },
                { 0, 0 },
                { 1, 0 },
                { 0, 0 },
        };

        int res = uniquePathsWithObstacles(A);
        System.out.println(res);
    }
}
