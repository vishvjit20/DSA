package Trees;

public class CheckForBSTWithOneChild {
    boolean checkPre(int[] pre, int n) {
        int next, last;
        for (int i = 0; i < n - 1; i++) {
            next = pre[i] - pre[i + 1];
            last = pre[i] - pre[n - 1];
            if (next * last < 0) {
                return false;
            }
        }
        return true;
    }

    public String solve(int[] A) {

        boolean res = checkPre(A, A.length);
        if (res)
            return "YES";
        return "NO";
    }
}
