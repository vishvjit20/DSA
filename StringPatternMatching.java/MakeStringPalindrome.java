
public class MakeStringPalindrome {
    public static int solve(String str) {
        StringBuilder s = new StringBuilder();
        s.append(str);
        StringBuilder rev = new StringBuilder(str);
        // rev.append(str);
        s.append('$');
        s.append(rev.reverse());
        System.out.println(s);

        int n = s.length();
        int z[] = new int[n];
        char[] charStr = new String(s).toCharArray();
        z_function(charStr, z);

        int start = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (charStr[i] == '$')
                start = i;
            else if (start != 0) {
                System.out.println("Start is " + start + "  " + (i - start + z[i]) * 2);
                if ((i - start + z[i]) * 2 >= n) {
                    return count;
                }
                count++;
            }
        }
        return -1;
    }

    static void z_function(char[] s, int z[]) {
        int l = 0, r = 0;
        int n = s.length;
        for (int i = 0; i < n; i++) {
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

    public static void main(String[] args) {
        int res = solve("babb");
        System.out.println(res);
    }
}
