package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q6 {
    /**
     * 按行访问
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }
        int cur = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            list.get(cur).append(s.charAt(i));
            if (cur == 0 || cur == list.size() - 1) flag = !flag;
            cur += flag ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder t:list){
            sb.append(t);
        }
        return sb.toString();
    }
}
