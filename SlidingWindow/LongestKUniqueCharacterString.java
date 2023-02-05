package SlidingWindow;

import java.util.*;

public class LongestKUniqueCharacterString {
    public int longestkSubstr(String s, int k) {
        int i = 0, j = 0;
        int n = s.length();
        int res = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while (j < n) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() == k) {
                res = Math.max(res, j - i + 1);
            } else if (map.size() > k) {
                while (map.size() > k) {
                    char ch = s.charAt(i);
                    if (map.get(ch) == 1)
                        map.remove(ch);
                    else
                        map.put(c, map.get(ch) - 1);
                    i++;
                }
            }
            j++;
        }

        return res;
    }
}
