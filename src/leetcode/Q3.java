package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        while (i <= j && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            ans = Math.max(ans, j - i);
            map.put(s.charAt(j), j);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] arr = new int[26];
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(i, arr[s.charAt(j) - 'a']);
            ans=Math.max(ans,j-i+1);
            arr[s.charAt(j)-'a']=j+1;
        }
        return ans;
    }

}
