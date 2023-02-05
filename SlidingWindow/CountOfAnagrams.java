package SlidingWindow;

import java.util.*;

public class CountOfAnagrams {
    int search(String pat, String txt) {
        int start = 0, end = 0, count = 0, ans = 0, k = pat.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            char c = pat.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (end < txt.length()) {
            char c = txt.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count++;
                }
            }
            if (end - start + 1 < k)
                end++;
            else if (end - start + 1 == k) {
                if (count == k)
                    ans++;
                char c2 = txt.charAt(start);
                if (map.containsKey(c2)) {
                    if (map.get(c2) >= 0)
                        count--;
                    map.put(c2, map.get(c2) + 1);
                }
                start++;
                end++;
            }
        }
        return ans;
    }
}
