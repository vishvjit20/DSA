import java.util.*;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    static void backtrack(int nums[], int idx, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 4 };
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }
}
