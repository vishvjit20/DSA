package BinarySearch;

public class SquareRootOfInteger {
    public int sqrt(int A) {
        int low = 1, high = A;
        int res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == A / mid)
                return mid;
            else if (mid < A / mid) {
                res = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return res;
    }
}
