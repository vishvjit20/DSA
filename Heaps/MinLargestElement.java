package Heaps;

import java.util.*;

public class MinLargestElement {
    static class Node implements Comparable<Node> {
        int node, incrementBy;

        public Node(int node, int incrementBy) {
            this.node = node;
            this.incrementBy = incrementBy;
        }

        public int compareTo(Node n) {
            return this.node + this.incrementBy - n.node - n.incrementBy;
        }
    }

    public static int solve(int[] A, int B) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int maxVal = Integer.MIN_VALUE;
        for (int ele : A) {
            pq.add(new Node(ele, ele));
            maxVal = Math.max(maxVal, ele);
        }
        while (B-- > 0) {
            Node rem = pq.remove();
            System.out.println(rem.node);
            maxVal = Math.max(maxVal, rem.node);
            int curr_updated = rem.node + rem.incrementBy;
            pq.add(new Node(curr_updated, rem.incrementBy));
        }

        return maxVal;
    }

    public static void main(String[] args) {
        int A[] = { 5, 7, 8 };
        int B = 9;
        int res = solve(A, B);
        System.out.println(res);
    }
}
