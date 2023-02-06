package Heaps;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair p) {
            return -this.x * this.x + p.x * p.x - this.y * this.y + p.y * p.y;
        }

    }

    public int[][] solve(int[][] A, int k) {
        int[][] res = new int[k][2];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int row[] : A)
            pq.add(new Pair(row[0], row[1]));
        while (pq.size() > k)
            pq.poll();
        int idx = 0;
        while (pq.size() > 0) {
            Pair p = pq.poll();
            res[idx][0] = p.x;
            res[idx][1] = p.y;
            idx++;
        }
        return res;
    }
}
