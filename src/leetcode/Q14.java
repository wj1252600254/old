package leetcode;

public class Q14 {
    /**
     * 暴力法
     * @param strs
     * @return
     */
    /*与此方法思路相似，但细节处理比不上
    public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);
        }
    }
    return strs[0];
}
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String ans = "";
        int min = Integer.MAX_VALUE;
        for (String s : strs) {
            min = Math.min(min, s.length());
        }
        for (int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (c != s.charAt(i))
                    return ans;
            }
            ans += String.valueOf(strs[0].charAt(i));
        }
        return ans;
    }

    /**
     * 水平扫描法
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String ans=strs[0];
        for(int i=1;i<strs.length;i++){
            while (strs[i].indexOf(ans)!=0){
                ans=strs[0].substring(0,ans.length()-1);
                if(ans.isEmpty())return "";
            }
        }
        return ans;
    }

    /**
     * https://leetcode.com/articles/implement-trie-prefix-tree/
     * 用字典树
     */
}
