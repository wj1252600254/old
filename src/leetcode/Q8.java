package leetcode;

import java.util.HashMap;

public class Q8 {
    public static void main(String[] args) {
        System.out.println(Character.isDigit('3'));
    }
    public int myAtoi(String str) {
        int result = 0;
        boolean isNegative = false;
        String s = str.trim();  //timr()返回的字符串才是想要的
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                if (chars[0] == '+') {
                    continue;
                } else if (chars[0] == '-') {
                    isNegative = true;
                } else if (chars[0] >= '0' && chars[0] <= '9') {  //第一个如果为数字，应该把数字加到result中来
                    result = chars[0] - '0';
                    continue;
                } else {
                    break;
                }
            } else {   //此处应该加判断，如果后面有非数字的字符，直接结束的。
                if (chars[i] >= '0' && chars[i] <= '9') {
                    if ((!isNegative) && (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && (chars[i] - '0') > 7)) {
                        return Integer.MAX_VALUE;
                    } else if (isNegative && (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && (chars[i] - '0') > 8)) {
                        return Integer.MIN_VALUE;
                    } else {
                        result = result * 10 + (chars[i] - '0');
                    }
                } else {
                    break;
                }
            }
        }
        return isNegative ? -result : result;
    }
}
