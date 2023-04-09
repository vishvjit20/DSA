import java.util.*;

public class AlienDictionary {

    public static void alienOrder(String words[]) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> inDeg = new HashMap<>();

        int n = words.length;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDeg.put(c, 0);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];

            boolean flag = false;
            int len = Math.min(curr.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)) {
                        set = map.get(c1);
                        if (!set.contains(c2)) {
                            set.add(c2);
                            inDeg.put(c2, inDeg.get(c2) + 1);
                            map.put(c1, set);
                        }
                    } else {
                        set.add(c2);
                        inDeg.put(c2, inDeg.get(c2) + 1);
                        map.put(c1, set);
                    }
                    flag = true;
                    break;
                }
            }
            if (!flag && curr.length() > next.length()) {
                System.out.println("-1");
                return;
            }
        }

        LinkedList<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (char c : inDeg.keySet()) {
            if (inDeg.get(c) == 0) {
                q.addLast(c);
            }
        }

        int count = 0;
        while (q.size() > 0) {
            char rem = q.removeFirst();
            ans.append(rem);
            count++;
            if (map.containsKey(rem)) {
                Set<Character> nbrs = map.get(rem);
                for (char nbr : nbrs) {
                    inDeg.put(nbr, inDeg.get(nbr) - 1);
                    if (inDeg.get(nbr) == 0) {
                        q.addLast(nbr);
                    }
                }
            }
        }

        if (count == inDeg.size()) {
            System.out.println(ans.toString());
        } else
            System.out.println("-1");
    }

    public static void main(String args[]) {
        String words[] = { "baa", "abcd", "abca", "cab", "cad" };

        alienOrder(words);
    }
}
