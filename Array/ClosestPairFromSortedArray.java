public class ClosestPairFromSortedArray {
    public int[] solve(int[] A, int[] B, int C) {
        int n = A.length, m = B.length;
        int i = 0, j = m - 1;
        int first = A[0];
        int second = B[m - 1];
        int min = Math.abs(A[i] + B[j] - C);

        while (i < n && j >= 0) {
            int sum = A[i] + B[j];
            int abs = Math.abs(A[i] + B[j] - C);

            if (abs == min && A[i] == first)
                second = B[j];

            if (abs < min) {
                min = abs;
                first = A[i];
                second = B[j];
            }
            if (sum >= C)
                j--;
            else
                i++;
        }
        return new int[] { first, second };
    }
}
