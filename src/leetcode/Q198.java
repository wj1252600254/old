package leetcode;

public class Q198 {
    public int rob(int[] nums) {
        int len = nums.length;
        int pre1 = 0;
        int pre2 = 0;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            cur = Math.max(pre1 = nums[i], pre2);
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }

    public int rob2(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);   //使用前考虑数组越界
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[nums.length-1];

    }
}
