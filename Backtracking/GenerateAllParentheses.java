package Backtracking;

import java.util.*;

public class GenerateAllParentheses {
    public static List<String> generateParentheses(int n) {

        List<String> res = new ArrayList<>();

        backtrack(res, 0, 0, "", n);
        return res;
    }

    static void backtrack(List<String> res, int open, int close, String str, int n) {
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }
        if (open < n)
            backtrack(res, open + 1, close, str + "(", n);
        if (close < open)
            backtrack(res, open, close + 1, str + ")", n);
    }

    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
    }
}
