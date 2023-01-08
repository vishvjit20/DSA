import java.util.*;

public class MaxNonNegativeSubarray {
    public int[] maxset(int[] A) {
        long sum = 0, maxSum = 0;

        ArrayList<Integer> maxArr = new ArrayList<>();
        ArrayList<Integer> resArr = new ArrayList<>();

        for (int val : A) {
            if (val >= 0) {
                sum += val;
                maxArr.add(val);
            } else {
                sum = 0;
                maxArr = new ArrayList<>();
            }
            if (maxSum < sum || maxSum == sum && (maxArr.size() > resArr.size())) {
                maxSum = sum;
                resArr = maxArr;
            }
        }
        return resArr.stream().mapToInt(v -> v).toArray();
    }
}
