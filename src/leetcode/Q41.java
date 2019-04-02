package leetcode;


import java.util.HashSet;
import java.util.Set;

public class Q41 {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int j = 1; j <= nums.length; j++) {
            if (!set.contains(j))
                return j;
        }
        return nums.length + 1;
    }
    /**
     * int[]?
     */

}
