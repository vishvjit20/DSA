package Heaps;

import java.util.PriorityQueue;

public class MishaAndCandies {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : A)
            pq.add(val);
        int res = 0;
        while (pq.size() > 1 && pq.peek() <= B) {
            int a = pq.poll();
            int b = pq.poll();

            int x = a / 2;
            res += x;
            pq.add(b + (a - x));
        }
        if (pq.peek() <= B) {
            res += pq.poll() / 2;
        }
        return res;
    }
}
