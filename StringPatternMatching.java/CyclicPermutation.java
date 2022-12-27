
public class CyclicPermutation {
    public int solve(String A, String B) {
        B = B + B;
        String str = A + '#' + B;
        int n = A.length();
        int len = str.length();
        int z[] = new int[len];
        z_function(str.toCharArray(), z);
        int count = 0;
        for (int i = n + 1; i < len; i++) {
            if (z[i] == n) {
                count++;
            }
        }

        return count;
    }

    void z_function(char[] s, int z[]) {
        int n = s.length;
        int l = 0, r = 0;
        for (int i = 0; i < s.length; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
                ++z[i];
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
    }
}
