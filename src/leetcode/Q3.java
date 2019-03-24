package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(new Q3().lengthOfLongestSubstring1("abba"));
    }

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
                i = map.get(s.charAt(j));//  以abba为例，a b b的时候都没有问题，但当a 出现时，map.get得到的是1  ，实际上，i 现在的位置在 2，这种情况下，结果就相差1
            }

            ans = Math.max(ans, j - i + 1);  //j-i+1,
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] arr = new int[26];
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(i, arr[s.charAt(j) - 'a']);
            ans = Math.max(ans, j - i + 1);
            arr[s.charAt(j) - 'a'] = j + 1;
        }
        return ans;
    }

}
