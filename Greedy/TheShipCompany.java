package Greedy;

import java.util.PriorityQueue;

public class TheShipCompany {
    public int[] solve(int A, int B, int[] C) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int val : C) {
            minHeap.add(val);
            maxHeap.add(val);
        }

        int minEarn = 0, maxEarn = 0;
        while (A-- > 0 && !minHeap.isEmpty() && !maxHeap.isEmpty()) {
            int a = minHeap.remove();
            int b = maxHeap.remove();

            minEarn += a;
            maxEarn += b;

            if (a > 1)
                minHeap.add(a - 1);
            if (b > 1)
                maxHeap.add(b - 1);
        }

        return new int[] { maxEarn, minEarn };
    }
}
