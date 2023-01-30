import java.util.*;

public class TriangleSum {
    public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int prev[] = new int[n];
        int curr[] = new int[n];

        for (int j = 0; j < n; j++) {
            prev[j] = A.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = A.get(i).get(j) + prev[j];
                int dia = A.get(i).get(j) + prev[j + 1];
                curr[j] = Math.min(dia, down);
            }
            prev = curr.clone();
        }

        return prev[0];
    }
}
