public class 斐波那契数列 {
    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     * @param n
     * @return
     */
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n<=1){
            return n;
        }
        int[] dp=new int[n+1];   //因为是从0开始的，所以得加一
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){   //i<n是不对的,f(n)有多少，就考虑多少
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public int Fibonacci1(int n) {
        if(n<=1){
            return n;
        }
        int pre1=0;
        int pre2=1;
        int cur=0;
        for(int i=2;i<n;i++){
            cur=pre1+pre2;
            pre1=pre2;
            pre2=cur;
        }
        return pre2;
    }


}
