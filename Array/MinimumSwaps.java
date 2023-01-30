import java.util.Arrays;

public class MinimumSwaps {
    class Pair implements Comparable<Pair> {
        int val, idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Pair p) {
            return this.val - p.val;
        }
    }

    void swap(Pair[] arr, int i, int j) {
        int temp = arr[i].idx;
        arr[i].idx = arr[j].idx;
        arr[j].idx = temp;
    }

    public int solve(int[] A) {
        int n = A.length;
        Pair[] pair = new Pair[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(A[i], i);
        }

        Arrays.sort(pair);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (pair[i].idx == i)
                continue;
            else {
                cnt++;
                swap(pair, i, pair[i].idx);
                i--;
            }
        }
        return cnt;
    }
}
