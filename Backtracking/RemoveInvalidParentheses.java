package Backtracking;

import java.util.*;

public class RemoveInvalidParentheses {
    int minCount = Integer.MAX_VALUE;
    HashSet<String> set = new HashSet<String>();
    HashSet<String> usedString = new HashSet<String>();

    public int getMin(String str) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            if (str.charAt(i) == ')') {
                if (stack.size() == 0) {
                    stack.add(')');
                    continue;
                }
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(')');
                }
            }
        }

        return stack.size();
    }

    public void permuteString(String s, int mra) {
        if (mra == 0) {
            if (getMin(s) == 0) {
                set.add(s);
            }
            return;
        }

        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')')
                continue;

            if (usedString.contains(s.substring(0, i) + s.substring(i + 1))) {
                continue;
            }
            usedString.add(s.substring(0, i) + s.substring(i + 1));
            permuteString(s.substring(0, i) + s.substring(i + 1), mra - 1);
        }
    }

    public ArrayList<String> solve(String s) {
        int min = getMin(s);
        permuteString(s, min);

        ArrayList<String> list = new ArrayList<String>();

        if (set.size() == 0) {
            list.add("");
            return list;
        }

        for (String str : set)
            list.add(str);

        return list;
    }

}
