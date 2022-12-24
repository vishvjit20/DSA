package Backtracking;

import java.util.*;

public class AllPermutations {
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        permute(A, 0, res);
        return res;
    }

    static void permute(ArrayList<Integer> arr, int idx, ArrayList<ArrayList<Integer>> res) {
        if (idx == arr.size()) {
            res.add(new ArrayList<>(arr));
            return;
        }
        for (int i = idx; i < arr.size(); i++) {
            Collections.swap(arr, i, idx);
            permute(arr, idx + 1, res);
            Collections.swap(arr, i, idx);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(permute(arr));
    }
}
