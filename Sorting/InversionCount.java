package Sorting;

public class InversionCount {

    int merge(int arr[], int l, int y, int r) {
        int c[] = new int[r - l + 1];
        int i = l, j = y, count = 0;
        int idx = 0;
        while (i < y && j <= r) {
            if (arr[i] <= arr[j]) {
                c[idx++] = arr[i++];
            } else {
                count += (y - i);
                c[idx++] = arr[j++];
            }
        }
        while (i < y)
            c[idx++] = arr[i++];
        while (j <= r)
            c[idx++] = arr[j++];
        idx = 0;
        for (i = l; i <= r; i++) {
            arr[i] = c[idx++];
        }
        return count;
    }

    int invCount(int arr[], int left, int right) {
        int MOD = 1000000007;
        if (left == right)
            return 0;
        int mid = (left + right) / 2;
        int a = invCount(arr, left, mid) % MOD;
        int b = invCount(arr, mid + 1, right) % MOD;
        int ab = merge(arr, left, mid + 1, right) % MOD;
        return (a + b + ab) % MOD;
    }

    public int solve(int[] A) {
        return invCount(A, 0, A.length - 1);
    }
}
