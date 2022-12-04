package HashMap;

import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (char c : t.toCharArray()) {
            m2.put(c, m2.getOrDefault(c, 0) + 1);
        }

        int i = -1, j = -1;
        String res = "";
        int mtc = 0;
        int dmtc = t.length();

        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;

            while (i < s.length() - 1 && mtc < dmtc) {
                char c = s.charAt(++i);
                m1.put(c, m1.getOrDefault(c, 0) + 1);

                if (m1.getOrDefault(c, 0) <= m2.getOrDefault(c, 0)) {
                    mtc++;
                }

                flag1 = true;
            }

            while (j < i && mtc == dmtc) {
                String temp = s.substring(j + 1, i + 1);
                if (res.length() == 0 || temp.length() < res.length())
                    res = temp;

                j++;
                char c = s.charAt(j);
                if (m1.get(c) == 0) {
                    m1.remove(c);
                } else
                    m1.put(c, m1.get(c) - 1);

                if (m1.getOrDefault(c, 0) < m2.getOrDefault(c, 0)) {
                    mtc--;
                }
                flag2 = true;
            }

            if (!flag1 && !flag2)
                break;
        }
        return res;

    }
}
