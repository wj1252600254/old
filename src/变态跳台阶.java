public class 变态跳台阶 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target <= 2)
            return target;
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 1; i < target; i++) {   //此处i=1开始
            for (int j = 0; j<i; j++){
                dp[i]+=dp[j];
            }
        }
        return dp[target-1];  //得注意数组越界啊!!!
    }
}
