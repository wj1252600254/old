package leetcode;

public class Q10 {
    /**
     * 动态规划
     * dp[m][n]代表的[0,m)[0,n)的字符串能够相匹配
     *
     * @param s
     * @param p
     * @return
     */
    /*https://github.com/foxleezh/leetcode-java/blob/master/src/solution/Q10.java
         int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    //如果是“*”，则判断是否重复0次还是重复多次（如果重复多次的话，还保证p[0:j]和s[0:i - 1]也能够匹配）
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else {
                    //如果不是“*”，则直接看对应的是否匹配, i = 0 是初始状态
                    dp[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                            && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
     */
    public boolean isMatch(String s, String p) {
        int s_len = s.length();
        int p_len = p.length();
        boolean[][] dp = new boolean[s_len + 1][p_len + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s_len; i++) {
            for (int j = 1; j <= p_len; j++) {
                if (p.charAt(j - 1) == '*') {
//                    if ((i > 0 && s.charAt(i - 1) == p.charAt(j-1)) || p.charAt(j - 1) == '.')
//                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j - 1];
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else {
                    dp[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i - 1][j - 1];
//                    if ((i > 0 && s.charAt(i - 1) == p.charAt(j-1)) || p.charAt(j - 1) == '.')
//                        dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s_len][p_len];
    }
}
