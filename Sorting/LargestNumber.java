package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(final int[] A) {
        String strVals[] = Arrays.stream(A).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strVals, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1.concat(s2);
                String c2 = s2.concat(s1);
                return c2.compareTo(c1);
            }
        });

        StringBuffer s = new StringBuffer();
        int count = 0;

        for (int i = 0; i < strVals.length; i++) {
            s.append(strVals[i]);
            if (Integer.parseInt(strVals[i]) == 0)
                count++;
        }
        if (count == strVals.length)
            return "0";
        return s.toString();
    }
}
