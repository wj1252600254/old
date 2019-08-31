package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18 {
    public static void main(String[] args) {
        /**
         * 测试Arrays.copyOf()
         */
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = Arrays.copyOfRange(a, 0, 1);
        System.out.println(Arrays.toString(b));
    }

    /**
     * 借助三数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int[] slip = Arrays.copyOfRange(nums, i + 1, nums.length);
                List<List<Integer>> list = threeSum(slip, target - nums[i]);
                    for (List<Integer> t : list) {
                        List<Integer> li = new ArrayList();
                        li.add(nums[i]);
                        li.addAll(t);
                        lists.add(li);
                    }
            }
        }
        return lists;
    }


    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3)
            return lists;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {    //这一步的作用是确保要求的sum值不重复

                int l = i + 1, h = nums.length - 1, sum = target - nums[i];
                while (l < h) {
                    if (nums[l] + nums[h] == sum) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[l]);
                        list.add(nums[h]);
                        list.add(nums[i]);
                        lists.add(list);
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
