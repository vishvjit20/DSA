package BinarySearch;

public class FoodPacketDistribution {
    public int solve(int[] A, int B) {
        int min = Integer.MAX_VALUE;
        for (int val : A) {
            min = Math.min(val, min);
        }
        int res = 0;
        int left = 1, right = min;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(A, B, mid)) {
                res = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return res;
    }

    boolean check(int A[], int B, int tar) {
        int people = 0;
        for (int val : A)
            people += Math.floor(val / tar);
        return people >= B;
    }
}
