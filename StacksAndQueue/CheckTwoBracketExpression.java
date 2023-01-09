package StacksAndQueue;

import java.util.*;

public class CheckTwoBracketExpression {
    public int solve(String A, String B) {
        int first[] = eval(A);
        int second[] = eval(B);
        for (int i = 0; i < 26; i++) {
            if (first[i] != second[i]) {
                return 0;
            }
        }
        return 1;
    }

    private int[] eval(String str) {
        int res[] = new int[26];
        Stack<Boolean> st = new Stack<>();
        st.push(true);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-')
                continue;
            if (c == '(' && i > 0) {
                if (str.charAt(i - 1) == '-') {
                    st.push(!st.peek());
                } else {
                    st.push(st.peek());
                }
                continue;
            }

            if (c >= 'a' && c <= 'z') {
                if (i > 0 && str.charAt(i - 1) == '-') {
                    res[c - 'a'] = st.peek() ? -1 : 1;
                } else {
                    res[c - 'a'] = st.peek() ? 1 : -1;
                }
                continue;
            }
            if (c == ')') {
                st.pop();
            }
        }
        return res;
    }
}
