import java.util.Stack;

public class MaximumRectangle {
    int largestHistogramArea(int A[]) {
        int n = A.length;
        int nsl[] = new int[n];
        int nsr[] = new int[n];
        Stack<Integer> st = new Stack<>();
        nsl[0] = -1;
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i])
                st.pop();
            if (st.isEmpty())
                nsl[i] = -1;
            else
                nsl[i] = st.peek();
            st.push(i);
        }
        nsr[n - 1] = n;
        st = new Stack<>();
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] >= A[i])
                st.pop();
            if (st.isEmpty())
                nsr[i] = n;
            else
                nsr[i] = st.peek();
            st.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int area = (nsr[i] - nsl[i] - 1) * A[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int maximalRectangle(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] != 0) {
                    A[i][j] += A[i - 1][j];
                }
            }
        }
        int max_area = 0;
        for (int row[] : A) {
            int histogramArea = largestHistogramArea(row);
            max_area = Math.max(max_area, histogramArea);
        }
        return max_area;
    }
}
