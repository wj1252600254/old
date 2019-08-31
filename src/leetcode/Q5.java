--package leetcode;

public class Q5 {
    public static void main(String[] args) {
        String a = "abc";
        System.out.println(a.substring(0, 0));
        System.out.println(a.charAt(0));


    }

    /**
     * 中心扩展法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int L = 0, R = 0, len = 0;
        String ans = "";
        for (float i = 0; i < s.length(); i = (float) (i + 0.5)) {
            if (i - (int) i == 0) {
                L = (int) i;
                R = (int) i;
            } else {
                L = (int) i;
                R = (int) i + 1;
            }
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            R--;
            L++;
            String a = s.substring(L, R + 1);
            if (a.length() > len) {
                len = a.length();
                ans = a;
            }
        }
        return ans;
    }

    /**
     * 动态规划法
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return s;
        int max = 0;
        String ans = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j < 3) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i - 1][j + 1];
                }
                if (dp[i][j]) {
                    String bb = s.substring(j, i + 1);
                    if (bb.length() > max) {
                        max = i - j + 1;
                        ans = bb;
                    }
                }
            }
        }
        return ans;
    }
}
