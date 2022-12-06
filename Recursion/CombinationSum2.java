import java.util.*;

class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, target, 0, res, new ArrayList<>());
        return res;
    }

    void backtrack(int nums[], int tar, int idx, List<List<Integer>> res, List<Integer> list) {
        if (tar == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > tar)
                return;
            list.add(nums[i]);
            backtrack(nums, tar - nums[i], i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

}
