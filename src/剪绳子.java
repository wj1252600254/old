public class 剪绳子 {
    /**
     * 贪心算法
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 2)
            return 1;
        if (n == 3)
            return 2;
        int a = n / 3;
        int b = n - a * 3;
        if (b == 1) {
            a--;
            b += 3;
        }
        b /= 2;
        return ((int) Math.pow(3, a)) * ((int) Math.pow(2, b)); //此处b是余数，并不是幂指数，计算得注意啊
    }

    /**
     * 动态规划法
     *
     * @param n
     * @return
     */

    public int m2(int n) {
        if(n<2)
            return 0;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for (int i = 4; i <=n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
}
