package offer;

public class 二进制1的个数 {
    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * n&()n-1表示去除数中
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n!=0) {   //不是==
            n=n&(n-1);
            count++;
        }
        return count;
    }
}
