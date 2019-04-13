package leetcode;

public class Q494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = nums.length;
        if (sum < S || (sum + S) % 2 != 0) {
            return 0;
        }
        int target = (S + sum) / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j > nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

}
