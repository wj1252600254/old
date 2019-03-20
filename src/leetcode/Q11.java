package leetcode;

public class Q11 {
    /**
     * 双指针法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxaread=0;
        int l=0;
        int h=height.length-1;
        while(l<h){
            maxaread=Math.max(maxaread,Math.min(height[l],height[h])*(h-l));
            if(height[l]<height[h])
                l++;
            else
                h--;
        }
        return maxaread;
    }

    /**
     * 暴力法
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int maxaread=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                maxaread=Math.max(maxaread,Math.min(height[i],height[j])*(j-i));
            }
        }
        return maxaread;
    }
}
