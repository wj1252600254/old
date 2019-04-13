package leetcode;

import java.util.Arrays;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int len = 0;
        for (int n : nums) {
            int index = Arrays.binarySearch(dp, 0, len, n);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = n;
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}
