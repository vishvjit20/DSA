import java.util.*;

public class NoOfPermutationOfSquarefulArrays {
    boolean isSquare(int a, int b) {
        double sqr = Math.sqrt(a + b);
        return sqr == Math.floor(sqr);
    }

    int count = 0;

    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        helper(new ArrayList<>(), nums, new boolean[nums.length], -1);
        return count;
    }

    void helper(List<Integer> list, int nums[], boolean used[], int lastNum) {
        if (list.size() == nums.length)
            count++;
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i]))
                    continue;

                if (lastNum != -1) {
                    if (!isSquare(lastNum, nums[i])) {
                        continue;
                    }
                }

                used[i] = true;
                list.add(nums[i]);
                helper(list, nums, used, nums[i]);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}
