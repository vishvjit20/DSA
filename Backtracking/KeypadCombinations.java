package Backtracking;

import java.util.*;

public class KeypadCombinations {
    public ArrayList<String> letterCombinations(String A) {
        Map<Integer, String> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        combinations(0, A, map, res);
        return res;
    }

    void combinations(int idx, String str, Map<Integer, String> map, ArrayList<String> res) {
        if (str.length() == 0) {
            res.add("");
            return;
        }
        char c = str.charAt(0);
        String rem = str.substring(1);
        ArrayList<String> remainingList = letterCombinations(rem);
        String pat = map.get(c - '0');
        for (int i = 0; i < pat.length(); i++) {
            char code = pat.charAt(i);
            for (String s : remainingList) {
                res.add(code + s);
            }
        }
    }

}
