package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q13 {
    public int romanToInt(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();     //也可以用数组进行储存int[128]，实际上int[90]就可以了，因为X的ASCII的值为90
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && map.get(chars[i]) < map.get(chars[i + 1])) {     //可以进行空间优化
                ans -= map.get(chars[i]);
            } else {
                ans += map.get(chars[i]);
            }
        }

        int max=0;
        for(int i=chars.length-1;i>=0;i--){
            if(map.get(chars[i])>=max){   //>=
                max=map.get(chars[i]);
                ans+=max;
            }else {
                ans-=map.get(chars[i]);
            }
        }


        return ans;

    }

}
