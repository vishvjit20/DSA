
package Heaps;

import java.util.*;

public class KthSmallestInMatrix {
    public static int solve(int[][] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = A.length;
        int m = A[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pq.size() < B)
                    pq.add(A[i][j]);
                else {
                    if (pq.peek() > A[i][j]) {
                        pq.remove();
                        pq.add(A[i][j]);
                    } else
                        continue;
                }
            }
        }
        System.out.println(pq);
        return pq.peek();
    }

    public static void main(String[] args) {
        int A[][] = {
                { 3, 5, 7, 9 },
                { 4, 6, 9, 12 },
                { 5, 9, 12, 16 },
                { 6, 10, 14, 19 },
        };
        int B = 15;
        int res = solve(A, B);
        System.out.println(res);
    }
}
