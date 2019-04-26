package leetcode;

import java.util.Arrays;

public class Q416 {
    /**
     * @param nums
     * @return空间优化版本
     */
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

    /**
     * 二维数组
     * 0   1   2   3   4   5   6   7   8   9   10  11
     * 0  T   F   F   F   F   F   F   F   F   F   F   F
     * 1  F   T   F   F   F   F   F   F   F   F   F   F
     * 2  F   T   F   F   F   F   T   F   F   F   F   F
     * 3  F   T   F   F   F   F   T   F   F   F   F   T
     * 4  F   T   F   F   F   F   F   F   F   F   F   T
     *
     * @return
     */
    public boolean twoArray(int[] nums) {
        int s = sum(nums);
        if (s % 2 != 0)
            return false;
        int sum = s / 2;
        int len = nums.length;
        boolean[][] dps = new boolean[len + 1][sum + 1];
        dps[0][0] = true;
        for (int i = 1; i <= len; i++) {
            int n = nums[i - 1];
            for (int j = 1; j <= sum; j++) {
                if (j >= n) {
                    dps[i][j] = dps[i - 1][j] || dps[i - 1][j - n];
                } else {
                    dps[i][j] = dps[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dps));
        return dps[len][sum];
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
