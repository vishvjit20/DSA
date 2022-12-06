import java.util.*;

public class RemoveInvalidParentheses {
    static ArrayList<String> ans;

    static ArrayList<String> solve(String A) {
        int n = A.length();
        ans = new ArrayList<>();
        if (n == 1) {
            if (isParentheses(A.charAt(0)))
                ans.add("");
            else
                ans.add(A);
            return ans;
        }

        findValidStrings(A);
        if (ans.isEmpty())
            ans.add("");
        return ans;

    }

    static void findValidStrings(String A) {
        if (A.isEmpty())
            return;

        Queue<String> q = new LinkedList<>();
        q.add(A);
        Set<String> visited = new HashSet<>();
        visited.add(A);

        boolean found = false;
        while (!q.isEmpty()) {
            String str = q.poll();
            if (isValidString(str)) {
                ans.add(str);
                found = true;
            }
            if (found)
                continue;

            for (int i = 0; i < str.length(); i++) {
                if (isParentheses(str.charAt(i))) {
                    String tmp = str.substring(0, i) + str.substring(i + 1);
                    if (!visited.contains(tmp)) {
                        q.add(tmp);
                        visited.add(tmp);
                    }
                }
            }
        }
    }

    static boolean isParentheses(char c) {
        return (c == '(' || c == ')');
    }

    static boolean isValidString(String s) {
        if (s.isEmpty())
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add('(');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
