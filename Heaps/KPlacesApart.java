package Heaps;

import java.util.PriorityQueue;

public class KPlacesApart {
    public int[] solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < B; i++) {
            pq.offer(A[i]);
        }
        int n = A.length;
        int res[] = new int[n];
        for (int i = B; i < n; i++) {
            pq.offer(A[i]);
            res[i - B] = pq.poll();
        }
        for (int i = n - B; i < n; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
