package Math;

import java.util.*;

public class RearrangeArray {
    public void arrange(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++)
            A.set(i, A.get(i) * n);
        for (int i = 0; i < n; i++) {
            int idx = A.get(i) / n;
            int val = A.get(idx) / n;
            A.set(i, (A.get(i) + val) % n);
        }

        for (int i = 0; i < n; i++)
            A.set(i, A.get(i) % n);
    }
}
