import java.util.*;

public class InterleavingString {
    public int isInterleave(String A, String B, String C) {
        int l1 = A.length();
        int l2 = B.length();
        int l3 = C.length();

        if (l3 != l1 + l2)
            return 0;

        boolean res = check(A, B, C, l1, l2, l3, 0, 0, 0);
        return res ? 1 : 0;
    }

    Map<String, Boolean> memo = new HashMap<>();

    boolean check(String A, String B, String C, int l1, int l2, int l3, int p1, int p2, int p3) {

        if (p3 == l3)
            return p1 == l1 && p2 == l2;
        String key = p1 + "#" + p2 + "#" + p3;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (p1 == l1) {
            boolean res = B.charAt(p2) == C.charAt(p3) ? check(A, B, C, l1, l2, l3, p1, p2 + 1, p3 + 1) : false;
            memo.put(key, res);
            return res;
        }

        if (p2 == l2) {
            boolean res = A.charAt(p1) == C.charAt(p3) ? check(A, B, C, l1, l2, l3, p1 + 1, p2, p3 + 1) : false;
            memo.put(key, res);
            return res;
        }

        boolean one = false;
        boolean two = false;

        if (A.charAt(p1) == C.charAt(p3)) {
            one = check(A, B, C, l1, l2, l3, p1 + 1, p2, p3 + 1);
        }
        if (B.charAt(p2) == C.charAt(p3)) {
            two = check(A, B, C, l1, l2, l3, p1, p2 + 1, p3 + 1);
        }

        memo.put(key, one | two);
        return one | two;

    }
}
