
public class MinimumCostOfMatrixMultiplication {

    // public static int minCost(int nums[]) {
    // int n = nums.length;
    // int dp[][] = new int[n][n];
    // for (int row[] : dp)
    // Arrays.fill(row, -1);
    // return f(nums, 1, n - 1, dp);
    // }

    // static int f(int nums[], int i, int j, int dp[][]) {
    // if (i == j)
    // return 0;
    // if (dp[i][j] != -1) {
    // return dp[i][j];
    // }
    // int min = Integer.MAX_VALUE;
    // for (int k = i; k < j; k++) {
    // int steps = nums[i - 1] * nums[k] * nums[j] + f(nums, i, k, dp) + f(nums, k +
    // 1, j, dp);
    // if (steps < min)
    // min = steps;
    // }

    // return dp[i][j] = min;
    // }

    public static void main(String args[]) {
        int arr[] = { 10, 30, 50, 60 };
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    if (steps < min) {
                        min = steps;
                    }
                }
                dp[i][j] = min;
            }
        }

        System.out.println(dp[1][n - 1]);
    }
}
