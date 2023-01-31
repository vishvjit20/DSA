import java.util.*;

public class WordBreak {
    // Map<String, Boolean> map;

    // boolean dfs(String str, Set<String> set) {
    // if (str.equals(""))
    // return true;
    // if (map.containsKey(str)) {
    // return map.get(str);
    // }
    // for (int i = 1; i <= str.length(); i++) {
    // if (set.contains(str.substring(0, i)) && dfs(str.substring(i), set)) {
    // map.put(str, true);
    // return true;
    // }
    // }
    // map.put(str, false);
    // return false;
    // }

    // public boolean wordBreak(String s, List<String> wordDict) {
    // Set<String> set = new HashSet<>();
    // for (String val : wordDict) {
    // set.add(val);
    // }

    // map = new HashMap<>();
    // return dfs(s, set);
    // }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < len; i++) {
                if (dp[i] && wordDict.contains(s.substring(i, len))) {
                    dp[len] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
