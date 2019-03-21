package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q20 {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        System.out.println(map.get("a"));
    }

    /**
     * 正确的思路是使用栈
     *
     * @param s
     * @return
     */

    public boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char a = stack.isEmpty() ? '#' : stack.pop();
                if (a != map.get(c))
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 没有考虑( [ ) ]这种情况
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                if (map.containsKey(chars[i])) {
                    int num = map.get(chars[i]);
                    num += 1;
                    map.put(chars[i], num);
                } else {
                    map.put(chars[i], 1);
                }
            } else {
                if (chars[i] == ')') {
                    if (!map.containsKey('('))
                        return false;
                    else {
                        int num = map.get('(');
                        if (num == 0)
                            return false;
                        num -= 1;
                        map.put(chars[i], num);
                    }
                } else if (chars[i] == ']') {
                    if (!map.containsKey('['))
                        return false;
                    else {
                        int num = map.get('[');
                        if (num == 0)
                            return false;
                        num -= 1;
                        map.put(chars[i], num);
                    }
                } else {
                    if (!map.containsKey('{'))
                        return false;
                    else {
                        int num = map.get('{');
                        if (num == 0)
                            return false;
                        num -= 1;
                        map.put(chars[i], num);
                    }
                }
            }
        }
        return true;
    }
}
