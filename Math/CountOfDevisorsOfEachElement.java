package Math;

public class CountOfDevisorsOfEachElement {
    public int[] solve(int[] A) {
        int max = max(A);
        int spf[] = spf(max);
        int n = A.length;
        int res[] = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1;
            int temp = A[i];
            if (temp == 1) {
                res[i] = 1;
                continue;
            }
            while (temp > 1) {
                int c = 0;
                int spfNo = spf[temp];
                while (temp % spfNo == 0) {
                    c++;
                    temp /= spfNo;
                }
                count *= (c + 1);
            }
            res[i] = count;
        }

        return res;
    }

    int max(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int val : arr)
            max = Math.max(val, max);
        return max;
    }

    int[] spf(int n) {
        int[] spf = new int[n + 1];
        for (int i = 0; i <= n; i++)
            spf[i] = i;
        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    spf[j] = i;
                }
            }
        }
        return spf;
    }
}
