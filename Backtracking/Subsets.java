package Backtracking;

import java.util.*;

public class Subsets {
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(A, res, new ArrayList<>(), 0);
        return res;
    }

    static void backtrack(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int idx) {
        res.add(new ArrayList<>(list));
        for (int i = idx; i < arr.size(); i++) {
            list.add(arr.get(i));
            backtrack(arr, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(subsets(arr));
    }
}
