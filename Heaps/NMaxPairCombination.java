package Heaps;

import java.util.*;

public class NMaxPairCombination {
    class Pair {
        int i, j, val;

        public Pair(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }

    public int[] solve(int[] A, int[] B) {
        int n = A.length;
        int res[] = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        Set<String> s = new HashSet<>();
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;
        pq.add(new Pair(A[n - 1] + B[n - 1], n - 1, n - 1));
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            res[idx++] = rem.val;

            int i = rem.i, j = rem.j;
            String s1 = (i - 1) + "#" + j;
            String s2 = i + "#" + (j - 1);

            if (i > 0 && !s.contains(s1)) {
                s.add(s1);
                pq.add(new Pair(A[i - 1] + B[j], i - 1, j));
            }
            if (j > 0 && !s.contains(s2)) {
                s.add(s2);
                pq.add(new Pair(A[i] + B[j - 1], i, j - 1));
            }

            if (idx == n)
                break;
        }
        return res;
    }
}
