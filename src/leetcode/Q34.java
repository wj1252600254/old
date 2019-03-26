package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int l = 0;
        int h = nums.length - 1;
        int first = binarySearch(nums, l, h, target);
        int last = binarySearch(nums, l, h + 1, target + 1) - 1; //减1是为了得到坐标
        //两种情况是不符合要求的，一种是target大于数组中的任意数，first此时为num,length；另外一种情况为target小于数组中任意数
        //此时，target为0，或者在数组数的范围中，但不存在target，此时为最接近的小于target的数
        if (nums[first] != target || first == nums.length)

            return new int[]{-1, -1};
        else
            return new int[]{first, Math.max(first, last)};
    }

    public int binarySearch(int[] nums, int l, int h, int target) {
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
