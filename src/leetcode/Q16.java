package leetcode;

import java.util.Arrays;

public class Q16 {
    public static void main(String[] args) {
        Q16 q16=new Q16();
        int ans=q16.threeSumClosest(new int[]{-1,0,1,1,55},3);
        System.out.println(ans);
    }

    /**
     * 可以考虑用双指针来优化时间
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int l = i + 1, h = nums.length - 1, sum = target - nums[i];
                while (l < h) {
//                    while (l < h && nums[l] == nums[l + 1]) l++;      //此处不能删除重复的，会导致有些情况娶不到值
//                    while (l < h && nums[h] == nums[h - 1]) h--;
                    if (nums[l] + nums[h] == sum)
                        return target;
                    else if (nums[l] + nums[h] > sum) {
                        if (Math.abs(nums[l] + nums[h] + nums[i] - target) < min) {
                            min = Math.abs(nums[l] + nums[h] + nums[i] - target);
                            ans = nums[l] + nums[h] + nums[i];
                        }
                        h--;
                    } else {
                        if (Math.abs(nums[l] + nums[h] + nums[i] - target) < min) {
                            min = Math.abs(nums[l] + nums[h] + nums[i] - target);
                            ans = nums[l] + nums[h] + nums[i];
                        }
                        l++;
                    }
                }
            }
        }
        System.out.println(min);
        return ans;
    }
}
