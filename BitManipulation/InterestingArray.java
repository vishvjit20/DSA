package BitManipulation;

import java.util.*;

public class InterestingArray {
    public String solve(int[] A) {
        int sum = Arrays.stream(A).sum();
        if (sum % 2 == 0)
            return "YES";
        return "NO";
    }
}
