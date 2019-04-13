package leetcode;

public class Q303 {
<<<<<<< HEAD
    private int[] sums;

    public Q303(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] += sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1]-sums[i];   //不是j   -     i-1
    }
=======
>>>>>>> 897ba5a3c8764c5069c4601e42034bf9324ebfcc
}
