package StacksAndQueue;

import java.util.*;

public class MaxAndMin {
    public int solve(int[] A) {
        int n = A.length;
        if (n <= 1)
            return 0;
        if (n == 2)
            return Math.abs(A[0] - A[1]);
        int MOD = 1000000007;
        Stack<Integer> st = new Stack<>();
        int ngr[] = new int[n];
        int nsl[] = new int[n];
        nsl[0] = -1;
        ngr[n - 1] = n;
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            if (st.size() == 0)
                nsl[i] = -1;
            else
                nsl[i] = st.peek();
            st.push(i);
        }

        st = new Stack<>();
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] <= A[i]) {
                st.pop();
            }
            if (st.size() == 0)
                ngr[i] = n;
            else
                ngr[i] = st.peek();
            st.push(i);
        }

        int ngl[] = new int[n];
        int nsr[] = new int[n];
        ngl[0] = -1;
        nsr[n - 1] = n;
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] <= A[i]) {
                st.pop();
            }
            if (st.size() == 0)
                ngl[i] = -1;
            else
                nsr[i] = st.peek();
            st.push(i);
        }

        st = new Stack<>();
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            if (st.size() == 0)
                nsr[i] = n;
            else
                nsr[i] = st.peek();
            st.push(i);
        }

        long max = 0l, min = 0l;
        for (int i = 0; i < n; i++) {
            max += (1L * A[i] * (i - ngl[i]) % MOD * (ngr[i] - i) % MOD) % MOD;
            min += (1L * A[i] * (i - nsl[i]) % MOD * (nsr[i] - 1) % MOD) % MOD;
        }

        long ans = 0l;
        ans = (max - min) % MOD;
        if (ans < 0)
            ans += MOD;

        return (int) ans % MOD;
    }

}
