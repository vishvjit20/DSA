package Math;

public class CountPairs {
    public int solve(int[] A, int B) {
        int freq[] = new int[B];
        for (int val : A)
            freq[val % B]++;
        long res = 0l;
        res += (long) freq[0] * (freq[0] - 1) / 2;
        int i = 1, j = B - 1;
        while (i < j) {
            res += (long) freq[i] * freq[j];
            i++;
            j--;
        }
        if (i == j)
            res += (long) freq[i] * (freq[i] - 1) / 2;

        return (int) res % 1000000007;
    }
}
