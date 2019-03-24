package leetcode;

public class Q26 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 3, 4, 5, 5, 6};
        System.out.println(new Q26().removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return 1;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[count] != nums[i]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }
}
