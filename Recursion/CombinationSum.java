
import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, target, 0, res, new ArrayList<>());
        return res;
    }

    void backtrack(int nums[], int target, int idx, List<List<Integer>> res, List<Integer> list) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, target - nums[i], i, res, list);
            list.remove(list.size() - 1);
        }

    }
}
