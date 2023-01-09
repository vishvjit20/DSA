package StacksAndQueue;

import java.util.*;

public class TaskScheduling {
    public int solve(int[] A, int[] B) {
        Queue<Integer> q = new LinkedList<>();
        for (int val : A)
            q.add(val);
        int count = 0;

        for (int i = 0; i < B.length; i++) {
            while (B[i] != q.peek()) {
                count++;
                int n = q.peek();
                q.remove();
                q.add(n);
            }
            count++;
            q.remove();
        }
        return count;
    }
}
