public class 打印从1到最大的n位数 {
    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
     *
     * @param n
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n < 0)
            return;
        char[] chars = new char[n];
        p1(chars, 0);
    }

    public void p1(char[] chars, int digit) {
        if (chars.length == digit) {
            p2(chars);
            return;
        }
        for (int i = 0; i < 10; i++) {
            chars[digit] = (char) (i + '0');
            p1(chars, digit + 1);
        }

    }

    public void p2(char[] chars) {
        int index = 0;
        while (index < chars.length && chars[index] == '0')
            index++;
        while (index < chars.length) {
            System.out.println(chars[index++]);
        }
        System.out.println();
    }
}
