package HashMap;

import java.util.*;

public class MaxPointsOnALine {
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int maxPoints(int[][] A) {
        int n = A.length;
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int equal = 1;
            for (int j = i + 1; j < n; j++) {
                if (A[i][0] == A[j][0] && A[i][1] == A[j][1])
                    equal++;
                else {
                    int y = A[i][1] - A[j][1];
                    int x = A[i][0] - A[j][0];
                    int g = gcd(x, y);
                    String str = x / g + "#" + y / g;
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
            res = Math.max(res, equal);
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                res = Math.max(res, e.getValue() + equal);
            }
            map.clear();
        }
        return res;
    }
}
