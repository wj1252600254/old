package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("a", null);
        String s = map.putIfAbsent("a", "1");
        map.merge("a", "2", (o1, o2) ->
                o1 + o2
        );
        System.out.println(map.get("a"));
    }

    /**
     * 采用的是hashmap
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();

        int arrlength = words.length;
        if (arrlength == 0)
            return list;
        int wordlengh = words[0].length();
        Map<String, Integer> wordmap = new HashMap<>();
        for (String temp : words) {
            int a = wordmap.getOrDefault(temp, 0);
            wordmap.put(temp, a + 1);
        }

        for (int i = 0; i < s.length() - wordlengh * arrlength + 1; i++) {
            Map<String, Integer> hasword = new HashMap<>();
            int num = 0;
            while (num < arrlength) {
                String judge = s.substring(i + num * wordlengh, i + (num + 1) * wordlengh);   //subString的end不加1
                if (wordmap.containsKey(judge)) {
                    int a = hasword.getOrDefault(judge, 0);
                    hasword.put(judge, a + 1);
                    if (hasword.get(judge) > wordmap.get(judge))
                        break;
                } else
                    break;
                num++;
            }
            if (num == arrlength)   //不是wordlength
                list.add(i);
        }
        return list;

    }
}
