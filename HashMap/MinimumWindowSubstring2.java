package HashMap;

import java.util.*;

public class MinimumWindowSubstring2 {
    public int minWindow(String s, String t) {
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        for (char c : t.toCharArray())
            set.add(c);

        int i = -1, j = -1;
        Map<Character, Integer> map = new HashMap<>();
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            while (i < s.length() - 1 && map.size() < set.size()) {
                char c = s.charAt(++i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                flag1 = true;
            }

            while (j < i && map.size() == set.size()) {
                int currLen = j - i;
                if (currLen < len)
                    len = currLen;

                j++;
                char c = s.charAt(j);
                if (map.get(c) == 1)
                    map.remove(c);
                else
                    map.put(c, map.get(c) - 1);

                flag2 = true;
            }
            if (!flag1 && !flag2)
                break;
        }
        return len;
    }
}
