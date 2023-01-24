package Greedy;

public class BinaryStrings {
    // public int solve(String A, int B) {
    // char[] str = A.toCharArray();
    // int n = A.length();
    // int steps = 0;
    // for (int i = 0; i < n; i++) {
    // if (str[i] == 0 && i + B <= n) {
    // steps++;
    // for (int j = i; j < i + B; j++) {
    // if (str[i] == '0')
    // str[i] = '1';
    // else
    // str[i] = '0';
    // }
    // }
    // if (i + B > n)
    // break;
    // }

    // for (int i = 0; i < n; i++) {
    // if (str[i] == 1)
    // return -1;
    // }

    // return steps;
    // }

    public int solve(String A, int B) {
        int n = A.length();
        int flipMonitor[] = new int[n];
        int flipCount = 0;
        int xor = 0;
        for (int i = 0; i < n - B + 1; i++) {
            xor ^= flipMonitor[i];

            if ((xor == 0 && A.charAt(i) == '0') || (xor == 1 && A.charAt(i) == '1')) {
                flipCount++;
                xor ^= 1;
                if (i + B < n)
                    flipMonitor[i + B] = 1;
            }
        }

        for (int i = n - B + 1; i < n; i++) {
            xor ^= flipMonitor[i];

            if ((xor ^ (A.charAt(i) - '0')) == 0) {
                return -1;
            }
        }

        return flipCount;
    }
}
