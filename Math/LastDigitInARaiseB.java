public class LastDigitInARaiseB {
    static int MOD(char A[], int b) {
        int mod = 0;
        for (int i = 0; i < A.length; i++)
            mod = (mod * 10 + A[i] - '0') % b;
        return mod;
    }

    static int LastDigit(char a[], char b[]) {
        int l1 = a.length, l2 = b.length;
        if (l1 == 1 && l2 == 1 && a[0] == '0' && b[0] == '0')
            return 1;
        if (l2 == 1 && b[0] == '0')
            return 1;
        if (l1 == 1 && a[0] == '0')
            return 0;
        int exp = MOD(b, 4) == 0 ? 4 : MOD(b, 4);
        int res = (int) (Math.pow(a[l1 - 1], exp));
        return res % 10;
    }
}
