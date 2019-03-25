package leetcode;

public class Q31 {
    public void nextPermutation(int[] nums) {
        int a = nums.length - 2;
        while (a >= 0 && nums[a + 1] <= nums[a]) {
            a--;
        }
        if (a >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[a]) {
                j--;
            }
            swap(nums, a, j);
        }
        reverse(nums, a + 1);
    }

    public void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
