public class MaximumAbsoluteDifference {
    public int maxArr(int[] A) {
        int n = A.length;
        int max1 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE, min2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            max1 = Math.max(max1, A[i] + i);
            min1 = Math.min(min1, A[i] + i);
            max2 = Math.max(max2, A[i] - i);
            min2 = Math.min(min2, A[i] - i);
        }

        return Math.max(max1 - min1, max2 - min2);
    }
}
