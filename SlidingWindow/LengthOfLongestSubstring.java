package SlidingWindow;

import java.util.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, ans = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (j < n) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() == j - i + 1) {
                ans = Math.max(ans, j - i + 1);
            } else {
                while (map.size() < j - i + 1) {
                    char ch = s.charAt(i);
                    if (map.get(ch) == 1) {
                        map.remove(ch);
                    } else {
                        map.put(ch, map.getOrDefault(ch, 0) - 1);
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}
