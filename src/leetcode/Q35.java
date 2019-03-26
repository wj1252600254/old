package leetcode;

public class Q35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target)    //相等的情况已经包含在这里面了
                h = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
