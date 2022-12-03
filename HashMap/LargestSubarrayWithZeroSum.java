package HashMap;

import java.util.*;

public class LargestSubarrayWithZeroSum {
    static int maxLen(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = 0;
        int sum = 0;
        map.put(sum, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                length = Math.max(length, i - map.get(sum));
            }
        }

        return length;
    }

    public static void main(String args[]) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int n = 8;
        int res = maxLen(arr, n);
        System.out.println(res);
    }
}
