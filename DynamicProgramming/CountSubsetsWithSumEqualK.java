public class CountSubsetsWithSumEqualK {

    public static int countSubsets(int arr[], int k) {
        int n = arr.length;

        int prev[] = new int[k + 1];
        int curr[] = new int[k + 1];

        prev[0] = curr[0] = 1;

        if (arr[0] <= k)
            prev[arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                int no_take = prev[j];
                int take = 0;
                if (j >= arr[i]) {
                    take = prev[k - arr[i]];
                }
                curr[j] = take + no_take;
            }
            prev = curr.clone();
        }
        return prev[k];
    }

    static int f(int arr[], int k, int idx) {
        if (k == 0)
            return 1;

        if (idx == 0) {
            if (arr[idx] == k)
                return 1;
            return 0;
        }

        int no_take = f(arr, k, idx - 1);
        int take = 0;
        if (k >= arr[idx]) {
            take = f(arr, k - arr[idx], idx - 1);
        }

        return take + no_take;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3 }, k = 3;
        int count = countSubsets(arr, k);
        System.out.println(count);
    }
}
