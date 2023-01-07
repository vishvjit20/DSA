package Greedy;

public class AnotherCoinProblem {
    public int solve(int A) {
        int res = 0;
        while (A > 0) {
            res += A % 5;
            A /= 5;
        }
        return res;
    }
}
