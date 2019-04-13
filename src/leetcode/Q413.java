package leetcode;

public class Q413 {
<<<<<<< HEAD
    public int numberOfArithmeticSlices(int[] A) {
        int cur = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur += 1;
                sum += cur;
            } else {
                cur = 0;
            }
        }
        return sum;
    }
=======
>>>>>>> 897ba5a3c8764c5069c4601e42034bf9324ebfcc
}
