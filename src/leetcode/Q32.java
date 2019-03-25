package leetcode;

import java.util.Stack;

public class Q32 {
    /**
     * 利用栈的思想
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int count = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] booleans = new boolean[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                int c = stack.isEmpty() ? -1 : stack.pop();
                if (c != -1) {
                    booleans[i] = true;
                    booleans[c] = true;
                }
            } else {
                stack.push(i);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (booleans[i]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    /*动态规划
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0){
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
     */


}
