package leetcode;

public class Q45 {
    public int jump(int[] nums) {
        int cur = 0, pre = 0, i = 0, ans = 0;
        while (cur < nums.length - 1) {
            ans++;
            pre = cur;
            for (; i < pre; i++) {
                cur = Math.max(cur, i + nums[i]);
            }
        }
        return ans;
    }
}
