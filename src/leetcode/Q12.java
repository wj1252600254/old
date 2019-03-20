package leetcode;

public class Q12 {
    String[] roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int i=12;
        while (i>=0){
            while (num>=nums[i]){  //是>=，如果是大于的话，会漏加
                stringBuilder.append(roman[i]);
                num-=nums[i];
            }
            i--;
        }
        return new String(stringBuilder);
    }
    /*
     还有一种思路，用整数逆转的思路，先求个位，在用罗马的逆序表示数，最后将整个字符串逆转输出
     */
}
