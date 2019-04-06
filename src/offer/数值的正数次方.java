package offer;

public class 数值的正数次方 {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 使用递归实现
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean flag = false;
        if (exponent < 0) {
            exponent = -exponent;
            flag = true;
        }
        double power=0.0;
        if (exponent % 2 == 0) {
            power = Power(base * base, exponent / 2);
        } else {
            power = Power(base * base, (exponent - 1) / 2) * base;
        }
        return flag == false ? power:1/power;
    }
}
