package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Q15 {
    /**
     * 将三数之和转化为两束之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {    //这一步的作用是确保要求的sum值不重复
                int l = i + 1, h = nums.length - 1, sum = 0 - nums[i];
                while (l < h) {
                    if (nums[l] + nums[h] == sum) {
                        lists.add(Arrays.asList(nums[i], nums[l], nums[h]));
                        while (l < h && nums[l] == nums[l + 1]) l++;
                        while (l < h && nums[h] == nums[h - 1]) h--;
                        l++;
                        h--;
                    } else if (nums[l] + nums[h] < sum) {
                        l++;
                    } else {
                        h--;
                    }
                }
            }
        }
        return lists;
    }
}
