package leetcode;

public class Q42 {
    public int trap(int[] height) {
        int wall = 0;
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[i - 1]) {
                int fill = Math.min(height[wall], height[i]);
                for (int j = i - 1; j > wall && height[j] < fill; j--) {
                    sum += fill - height[j];
                    height[j] = fill;
                }
                wall = height[i] > height[wall] ? i : wall;
            }
        }
        return sum;
    }
    /**双指针
     *     public int trap(int[] h) {
     if(h.length == 0) return 0;
     int l = 0, r = h.length - 1, lm = h[l], rm = h[r], res = 0;

     while(l < r) {
     if(lm <= rm) {
     l++;
     if(h[l] < lm) res += lm - h[l];
     else lm = h[l];
     } else {
     r--;
     if(h[r] < rm) res += rm - h[r];
     else rm = h[r];
     }
     }
     return res;
     }
     */
}
