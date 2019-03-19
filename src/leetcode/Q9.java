package leetcode;

public class Q9 {

    public boolean f1(int x) {
        if (x < 0 || x % 10 == 0 && x != 0)   //x=0是特殊情况
            return false;
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == x || reverse / 10 == x;
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int result = 0;
        int copy = x;
        while (copy > 0) {
            int pop = copy % 10;
            copy /= 10;
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && pop > 7) {
//                result = Integer.MAX_VALUE;
//                break;        //这么写，过不了测试数据Integer.MAX_VALUE
                return false;  //即使是这样写因为有漏洞
            } else {
                result = result * 10 + pop;
            }
        }
        System.out.println(result);
        if (result == x)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Q9 q9 = new Q9();
        q9.isPalindrome(121);
    }
}
