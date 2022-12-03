package HashMap;

import java.util.*;

public class DistinctInWindowOfSizeK {
    public static int[] dNums(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int res[] = new int[n - k + 1];
        for (int i = 0; i < k - 1; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = k - 1, j = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            res[j] = map.size();
            int freq = map.get(nums[j]);
            if (freq == 1) {
                map.remove(nums[j]);
            } else {
                map.put(nums[j], freq - 1);
            }
            j++;
        }
        return res;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 1, 3, 4, 3 };
        int k = 3;
        int[] res = dNums(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
