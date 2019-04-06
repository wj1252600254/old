package leetcode;

public class Q50 {
    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * 当n取Integer.MIN_VALUE时，-n会溢出
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double ans = 0.0;
        if (n == Integer.MIN_VALUE) {
            x = 1 / (x * x);
            n /= -2;
//            x = x * x;
//            n = n / 2;                  //此处不能加
        } else if (n < 0) {
            n *= -1;
            x = 1 / x;
        }
        ans = myPow(x * x, n / 2);
        if (n % 2 != 0) {
            ans = x * ans;
        }
        return ans;
    }
}
