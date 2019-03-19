package leetcode;

public class Q416 {
    public boolean canPartition(int[] nums) {
        int s=sum(nums);
        if(s%2!=0)
            return false;
        int len=nums.length;
        int[][] dp=new int[len+1][s+1];
        for(int i=1;i<len;i++){
            for(int j=1;j<=s;j++){

            }
        }
return false;

    }

    public int sum(int[] arr){
        int sum=0;
        for(int temp:arr){
            sum+=temp;
        }
        return sum;
    }
}
