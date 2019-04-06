package offer;

public class 数组中只出现一次的数字 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(-3));
    }

    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        if (nums == null || nums.length == 0)
            return;
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }
}
