package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q46 {
    /**
     * 回溯算法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(nums, lists, new ArrayList<>());
        return lists;
    }

    public void dfs(int[] nums, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));  //此处new list，是因为list一直在变
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            dfs(nums, lists, list);
            list.remove(list.size() - 1);
        }
    }
}
