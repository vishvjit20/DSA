package BinarySearch;

import java.util.*;

public class MedianOf2Arrays {
    public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
        int n = A.size(), m = B.size();
        int left = 0, right = n - 1;
        while (left <= right) {
            int cut1 = (left + right) / 2;
            int cut2 = (n + m) / 2 - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : A.get(cut1 - 1);
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : A.get(cut2 - 1);
            int r1 = cut1 == n ? Integer.MAX_VALUE : A.get(cut1);
            int r2 = cut2 == m ? Integer.MAX_VALUE : A.get(cut2);
            if (l1 > r2)
                right = cut1 - 1;
            else if (l2 > r1)
                left = cut1 + 1;
            else {
                if ((n + m) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
                return Math.min(r1, r2);
            }
        }
        return 0.0;
    }
}
