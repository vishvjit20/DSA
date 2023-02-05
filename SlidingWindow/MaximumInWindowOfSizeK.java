package SlidingWindow;

import java.util.*;

public class MaximumInWindowOfSizeK {
    static int[] max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        int res[] = new int[n - k + 1];
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        nge[n - 1] = n;
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.size() == 0)
                nge[i] = n;
            else
                nge[i] = st.peek();
            st.push(i);
        }

        int j = 0;
        for (int i = 0; i <= n - k; i++) {
            if (j < i)
                j = i;
            while (nge[j] < i + k) {
                j = nge[j];
            }
            res[i] = arr[j];
        }
        return res;
    }
}
