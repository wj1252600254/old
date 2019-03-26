package leetcode;

public class Q33 {
    /**
     * 要求时间复杂度为logN，二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {   //<=
            int medium = l + (h - l) / 2;
            if (nums[medium] == target)
                return medium;
            if (nums[l] < nums[h])
                return binarySearch(nums, l, h, target);
            else if (nums[medium] >= nums[l]) {   //>=如果medium=l,不加=,则漏了这种情况
                if (target >= nums[l] && target < nums[medium])
                    h = medium - 1;
                else
                    l = medium + 1;
            } else {
                if (target > nums[medium] && target <= nums[h])
                    l = medium + 1;
                else
                    h = medium - 1;
            }
        }
        return -1;
    }


    public int binarySearch(int[] nums, int l, int h, int target) {
        while (l <= h) {  //<=
            int medium = l + (h - l) / 2;
            if (nums[medium] == target)
                return medium;
            else if (nums[medium] > target)
                h = medium - 1;
            else
                l = medium + 1;
        }
        return -1;
    }
}
