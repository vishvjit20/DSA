import java.util.Arrays;

public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];
        // for (int row[] : dp)
        // Arrays.fill(row, -1);
        // return f(points, n - 1, 3, dp);

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int i = 0; i <= 2; i++) {
                    if (i != last) {
                        int ans = points[day][i] + dp[day - 1][i];
                        max = Math.max(max, ans);
                    }
                }
                dp[day][last] = max;
            }
        }

        return dp[n - 1][3];
    }

    // static int f(int[][] points, int day, int task, int dp[][]) {

    // if (day == 0) {
    // int max = 0;
    // for (int i = 0; i <= 2; i++) {
    // if (i != task) {
    // max = Math.max(max, points[0][i]);
    // }
    // }
    // return max;
    // }

    // if (dp[day][task] != -1) {
    // return dp[day][task];
    // }

    // int max = 0;
    // for (int i = 0; i <= 2; i++) {
    // if (i != task) {
    // int ans = points[day][i] + f(points, day - 1, i, dp);
    // max = Math.max(max, ans);
    // }
    // }

    // return dp[day][task] = max;
    // }
}
