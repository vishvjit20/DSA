public class MaxChunks2 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        int suffixMin[] = new int[n];
        suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
        }
        int prefixMax = arr[0];
        int res = 1;
        for (int i = 0; i < n - 1; i++) {
            prefixMax = Math.max(prefixMax, arr[i]);
            if (prefixMax <= suffixMin[i + 1]) {
                res++;
            }
        }
        return res;
    }
}
