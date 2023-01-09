public class FirstMissingInteger {
    void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public int firstMissingPositive(int[] A) {

        int n = A.length;
        int i = 0;
        while (i < n) {
            if (A[i] >= 1 && A[i] <= n) {
                int correctPos = A[i] - 1;
                if (A[correctPos] != A[i]) {
                    swap(A, i, correctPos);
                } else
                    i++;
            } else
                i++;
        }

        for (i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
