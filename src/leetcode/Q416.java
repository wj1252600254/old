package leetcode;

public class Q416 {
    public boolean canPartition(int[] nums) {
        int s = sum(nums);
        if (s % 2 != 0)
            return false;
        int sum = s / 2;
        int len = nums.length;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = sum; i >= n; i--) {
                dp[i] = dp[i] || dp[i - n];
            }
        }
        return dp[len];
    }

/*
        int sum = 0;
        for(int e : a) sum += e;
        if(sum%2 != 0) return false;

        int t = sum / 2;
        boolean[][] dp = new boolean[a.length+1][t+1];
        dp[0][0] = true;
        for(int i = 1; i <= a.length; i++) {
            for(int j = 1; j <= t; j++) {
                dp[i][j] |= dp[i-1][j];
                if(j >= a[i-1]) dp[i][j] |= dp[i-1][j-a[i-1]];
            }
            if(dp[i][t]) return true;
        }
        return false;
 */

    public int sum(int[] arr) {
        int sum = 0;
        for (int temp : arr) {
            sum += temp;
        }
        return sum;
    }
}
