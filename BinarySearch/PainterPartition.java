package BinarySearch;

public class PainterPartition {
    public int paint(int A, int B, int[] C) {
        int max = Integer.MIN_VALUE;
        long sum = 0l;
        for (int i = 0; i < C.length; i++) {
            max = Math.max(max, C[i]);
            sum += C[i];
        }

        long left = max, right = sum;
        long res = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(C, A, mid)) {
                res = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return (int) ((res * B) % 10000003);
    }

    boolean check(int A[], int k, long tar) {
        int count = 1;
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > tar) {
                sum = A[i];
                count++;
            }
        }
        return count <= k;
    }
}
