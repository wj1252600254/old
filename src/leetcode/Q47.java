package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        dfs(nums, lists, new ArrayList<>(), isUsed);
        return lists;
    }

    public void dfs(int[] nums, List<List<Integer>> lists, List<Integer> list, boolean[] booleans) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (booleans[i] || i > 0 && nums[i] == nums[i - 1] && !booleans[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            booleans[i] = true;
            dfs(nums, lists, list, booleans);
            list.remove(list.size() - 1);
            booleans[i] = false;
        }
    }
}
