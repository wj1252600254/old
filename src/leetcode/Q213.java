package leetcode;

public class Q213 {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        return 1;

    }
    public int rob2(int[] nums,int first,int last) {

        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);   //使用前考虑数组越界
        for(int i=first;i<last;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[nums.length-1];

    }

}
