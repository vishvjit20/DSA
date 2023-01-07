package Heaps;

import java.util.*;

public class PriorityQueueImplementation {
    public static class PriorityQueue {
        ArrayList<Integer> data;
        boolean flag = false; // flag == false Min heap, else max heap

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public PriorityQueue(boolean flag) {
            data = new ArrayList<>();
            this.flag = flag;
        }

        private boolean priority(int x, int y) {
            if (!flag)
                return x > y;
            return y > x;
        }

        void add(int val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        private void upheapify(int idx) {
            if (idx == 0)
                return;
            int parentIdx = (idx - 1) / 2;
            if (priority(data.get(parentIdx), data.get(idx))) {
                swap(idx, parentIdx);
                upheapify(parentIdx);
            }
        }

        private void swap(int i, int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        int remove() {
            if (data.size() == 0) {
                System.out.println("Underflow...");
                return -1;
            }
            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }

        private void downheapify(int parentIdx) {
            int min = parentIdx;
            int leftIdx = 2 * parentIdx + 1;
            if (leftIdx < data.size() && priority(data.get(min), data.get(leftIdx))) {
                min = leftIdx;
            }
            int rightIdx = 2 * parentIdx + 2;
            if (rightIdx < data.size() && priority(data.get(min), data.get(rightIdx))) {
                min = rightIdx;
            }
            if (min != parentIdx) {
                swap(parentIdx, min);
                downheapify(min);
            }
        }

        public int peak() {
            if (data.size() == 0) {
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(true);
        pq.add(7);
        pq.add(3);
        pq.add(8);
        pq.add(1);
        pq.add(0);

        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
}
