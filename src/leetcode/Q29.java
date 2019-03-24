package leetcode;

public class Q29 {
    public static void main(String[] args) {
        long a = Math.abs((long) -2147483648);  //  2147483648
        long b=Math.abs(-2147483648);   //-2147483648
        System.out.println(a);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (dividend == 0)
            return 0;
        int count = 0;
        int flag = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
            flag = -1;
        long a = Math.abs((long) dividend);    //取int,最小的负数会溢出
        long b = Math.abs((long) divisor);
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {   //  >
                count += 1 << i;
                a -= b << i;
            }
        }
        return flag * count;

    }
}
