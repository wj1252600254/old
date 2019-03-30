package leetcode;

public class Q44 {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = (i > 0 && dp[i - 1][j]) || dp[i][j - 1];
                } else {
                    if ((i > 0) && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)))
                        dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
