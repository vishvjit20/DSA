package Backtracking;

import java.util.*;

public class AllUniquePermutations {
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        backtrack(A, res, 0, "", set);
        return res;
    }

    static void backtrack(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> res, int idx, String psf,
            HashSet<String> set) {
        if (idx == arr.size()) {
            if (!set.contains(psf)) {
                res.add(new ArrayList<>(arr));
                set.add(psf);
            }
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            Collections.swap(arr, idx, i);
            backtrack(arr, res, idx + 1, psf + "#" + arr.get(idx), set);
            Collections.swap(arr, idx, i);
        }
    }
}
