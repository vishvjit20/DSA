public class MaxChunks {
    public int maxChunksToSorted(int[] arr) {
        if (arr.length == 0)
            return 0;
        int max = 0, cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                cnt++;
        }
        return cnt;
    }
}
