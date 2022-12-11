package HashMap;

import java.util.HashMap;
import java.util.*;

public class LengthOfLongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String A) {
        int res = 0;
        int i = -1, j = -1;
        int n = A.length();
        Map<Character, Integer> map = new HashMap<>();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < n - 1) {
                i++;
                f1 = true;
                char c = A.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) == 2)
                    break;
                else {
                    int len = i - j;
                    if (len > res)
                        res = len;
                }
            }

            while (j < i) {
                j++;
                f2 = true;
                char c = A.charAt(j);
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 1)
                    break;
            }

            if (!f1 && !f2)
                break;
        }

        return res;
    }
}
