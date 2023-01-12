package Trees;

public class CheckForBSTWithOneChild {
    private boolean checkBST(int[] A, int N) {
        int leftRange = Integer.MIN_VALUE;
        int rightRange = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; ++i) {
            int currParent = A[i];
            int child = A[i + 1];
            if (currParent < child) {
                if (leftRange < child && child < rightRange)
                    leftRange = currParent;
                else
                    return false;
            } else {
                if (leftRange < child && child < rightRange)
                    rightRange = currParent;
                else
                    return false;
            }
        }
        return true;
    }

    public String solve(int[] A) {
        int N = A.length;
        if (N < 3)
            return "YES";
        if (checkBST(A, N))
            return "YES";
        return "NO";
    }
}
