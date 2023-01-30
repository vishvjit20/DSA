public class MinimumSwapsLessThanK {
    public int solve(int[] A, int k) {
        int n = A.length;
        int count = 0;
        for (int val : A) {
            if (val <= k)
                count++;
        }

        int currCount = 0, res = count;
        int left = 0, right = 0;
        while (right < n) {
            if (A[right] <= k)
                currCount++;
            right++;
            if (right - left < count)
                continue;
            res = Math.min(res, count - currCount);
            if (A[left] <= k)
                currCount--;
            left++;
        }

        return res;
    }
}
