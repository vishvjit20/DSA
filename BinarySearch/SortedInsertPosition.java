package BinarySearch;

public class SortedInsertPosition {

    public int searchInsert(int[] A, int B) {
        int n = A.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == B)
                return mid;
            else if (A[mid] > B)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
