package offer;

public class 替换空格 {
    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param str
     * @return
     */

    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0)
            return "";
        int len1 = str.length();
        for (int i = 0; i < len1; i++) {
            if (str.charAt(i) == ' ')
                str.append("  ");
        }
        int len = str.length()-1;
        char c;
        while (len > len1 && len1 >= 0) {  //len>=len1 用>更优，所消耗时间更少
            if ((c = str.charAt(len1 - 1)) == ' ') {
                str.setCharAt(len--, '0');
                str.setCharAt(len--, '2');
                str.setCharAt(len--, '%');
            }else
                str.setCharAt(len--,c);
            len1--;   //漏了
        }
        return str.toString();
    }
}
