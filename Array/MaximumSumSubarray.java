import java.util.Arrays;

public class MaximumSumSubarray {
    int kadane(int arr[]) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int arr[] = new int[n];
        int max = Integer.MIN_VALUE;
        for (int c = 0; c < m; c++) {
            Arrays.fill(arr, 0);
            for (int j = c; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    arr[i] += A[i][j];
                }

                int val = kadane(arr);
                if (val > max) {
                    max = val;
                }
            }
        }
        return max;
    }
}
