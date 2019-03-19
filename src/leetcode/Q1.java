package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public static void main(String[] args){
        Map<Integer,Integer> map=new HashMap<>();
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(map.containsKey(diff))    //得加判断，保证map.get(diff)!=i
                return new int[]{i,map.get(diff)};
        }
        return null;
    }
}
