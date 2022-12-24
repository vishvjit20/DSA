package Backtracking;

import java.util.*;

public class NoOfSquarefulArrays {
    boolean isSquare(int a, int b) {
        double sqrt = Math.sqrt(a + b);
        return sqrt - Math.floor(sqrt) == 0;
    }

    int count = 0;

    public int solve(ArrayList<Integer> A) {
        if (A.size() < 2)
            return 0;
        Collections.sort(A);
        boolean[] used = new boolean[A.size()];
        helper(new ArrayList<>(), A, used, -1);
        return count;
    }

    void helper(ArrayList<Integer> temp, ArrayList<Integer> arr, boolean[] used, int lnum) {
        if (temp.size() == arr.size())
            count++;
        else {
            for (int i = 0; i < arr.size(); i++) {
                if (used[i] || (i > 0 && arr.get(i) == arr.get(i - 1) && !used[i - 1])) {
                    continue;
                }
                if (lnum != -1) {
                    if (!isSquare(lnum, arr.get(i))) {
                        continue;
                    }
                }

                used[i] = true;
                temp.add(arr.get(i));
                helper(temp, arr, used, arr.get(i));
                temp.remove(temp.size() - 1);
                used[i] = false;
            }

        }
    }
}
