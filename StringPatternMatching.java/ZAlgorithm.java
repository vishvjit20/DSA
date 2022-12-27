public class ZAlgorithm {
    int z[] = new int[1000];

    void zFunction(String str) {
        z[0] = 0;
        int n = str.length();
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r)
                z[i] = Math.min(z[i - l], r - i + 1);
            while (i + z[i] < n && str.charAt(z[i]) == str.charAt(i + z[i])) {
                ++z[i];
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
    }

}
