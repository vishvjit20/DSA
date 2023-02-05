package SlidingWindow;

import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int n = s.length();
        int m = t.length();

        for (int i = 0; i < m; i++) {
            char c = t.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0, count = 0;
        String res = "";
        while (true) {
            boolean flag1 = false, flag2 = false;
            while (j < n && count < m) {
                char c = s.charAt(j);
                map1.put(c, map1.getOrDefault(c, 0) + 1);
                if (map1.getOrDefault(c, 0) <= map2.getOrDefault(c, 0)) {
                    count++;
                }
                j++;

                flag1 = true;
            }

            while (i < j && count == m) {
                String temp = s.substring(i, j);
                if (res.length() == 0 || temp.length() < res.length())
                    res = temp;
                char c = s.charAt(i);
                if (map1.get(c) == 1) {
                    map1.remove(c);
                } else {
                    map1.put(c, map1.get(c) - 1);
                }

                if (map1.getOrDefault(c, 0) < map2.getOrDefault(c, 0)) {
                    count--;
                }
                i++;
                flag2 = true;
            }

            if (!flag1 && !flag2) {
                break;
            }
        }

        return res;
    }
}
