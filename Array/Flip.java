public class Flip {
    public int[] flip(String A) {
        int sum = 0, maxSum = 0, l = 0, r = -1;
        int idx = 0;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            sum += c == '0' ? +1 : -1;
            if (sum < 0) {
                sum = 0;
                idx = i + 1;
            } else if (sum > maxSum) {
                maxSum = sum;
                l = idx;
                r = i;
            }
        }

        return r == -1 ? new int[] {} : new int[] { l + 1, r + 1 };
    }
}
