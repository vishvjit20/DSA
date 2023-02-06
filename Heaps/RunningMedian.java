package Heaps;

import java.util.*;

public class RunningMedian {
    public int[] solve(int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int n = A.length;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (maxHeap.size() == 0) {
                maxHeap.add(A[i]);
            } else {
                if (A[i] < maxHeap.peek()) {
                    maxHeap.add(A[i]);
                    if (maxHeap.size() - minHeap.size() > 1) {
                        minHeap.add(maxHeap.poll());
                    }
                } else {
                    minHeap.add(A[i]);
                    if (minHeap.size() - maxHeap.size() > 0) {
                        maxHeap.add(minHeap.poll());
                    }
                }
            }
            res[i] = maxHeap.peek();
        }
        return res;
    }
}
