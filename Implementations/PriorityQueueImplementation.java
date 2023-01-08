package Implementations;

import java.util.*;

public class PriorityQueueImplementation {
    public static class PriorityQueue {
        ArrayList<Integer> data;
        boolean flag;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public PriorityQueue(boolean flag) {
            data = new ArrayList<>();
            this.flag = flag;
        }

        public void add(int val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        private boolean priority(int x, int y) {
            if (!flag)
                return x > y;
            return y > x;
        }

        private void upheapify(int idx) {
            if (idx == 0)
                return;
            int parentIdx = (idx - 1) / 2;
            if (priority(data.get(parentIdx), data.get(idx))) {
                swap(parentIdx, idx);
                upheapify(parentIdx);
            }
        }

        private void swap(int i, int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public int remove() {
            if (data.size() == 0)
                return -1;
            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }

        private void downheapify(int idx) {
            int min = idx;
            int leftIdx = 2 * idx + 1;
            if (leftIdx < data.size() && priority(data.get(min), data.get(leftIdx))) {
                min = leftIdx;
            }
            int rightIdx = 2 * idx + 2;
            if (rightIdx < data.size() && priority(data.get(min), data.get(rightIdx))) {
                min = rightIdx;
            }

            if (min != idx) {
                swap(idx, min);
                downheapify(min);
            }
        }

        public int peek() {
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
        PriorityQueue que = new PriorityQueue();
        que.add(77);
        que.add(22);
        que.add(13);
        que.add(19);
        que.add(0);
        que.add(53);
        que.add(8);
        que.add(79);
        que.add(99);
        que.add(77);
        que.add(80);
        que.add(47);
        que.add(37);

        while (que.size() > 0) {
            System.out.println(que.remove());
        }

    }
}
