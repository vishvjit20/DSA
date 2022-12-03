package HashMap;

import java.util.HashMap;

public class CountZeroSumSubarray {
    public static long findSubarray(long[] arr, int n) {
        // Your code here
        HashMap<Long, Long> map = new HashMap<>();
        long sum = 0;
        map.put(sum, 1l);
        long count = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (!map.containsKey(sum)) {
                map.put(sum, 1l);
            } else {
                long freq = map.get(sum);
                count += freq;
                map.put(sum, freq + 1);
            }
        }

        return count;
    }

    public static void main(String args[]) {
        long arr[] = { 0, 0, 5, 5, 0, 0 };
        int n = 6;
        long res = findSubarray(arr, n);
        System.out.println(res);
    }
}
