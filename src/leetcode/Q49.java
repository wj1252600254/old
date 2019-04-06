package leetcode;

import java.util.*;

public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;
        Map<String, List> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sb = new String(chars);
            if (!map.containsKey(sb)) {
                map.put(sb, new ArrayList());
            }
            map.get(sb).add(s);
        }
        return new ArrayList(map.values());
    }
}
