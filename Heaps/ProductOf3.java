package Heaps;

import java.util.*;

public class ProductOf3 {
    public int[] solve(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int prod = 1;
        int n = A.length;
        int res[] = new int[n];
        for (int i = 0; i <= 2; i++) {
            pq.add(A[i]);
            prod *= A[i];
            if (i == 2)
                res[i] = prod;
            else
                res[i] = -1;
        }

        for (int i = 3; i < n; i++) {
            if (A[i] > pq.peek()) {
                int val = pq.poll();
                pq.add(A[i]);
                prod = prod / val * A[i];
            }
            res[i] = prod;
        }

        return res;
    }
}
