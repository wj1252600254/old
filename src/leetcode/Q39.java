package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, lists, list, 0);
        return lists;

    }

    public void dfs(int[] candidates, int target, List<List<Integer>> lists, List<Integer> list, int num) {
        if (target == 0) {
            lists.add(list);
            return;
        }
        if (target < candidates[0])
            return;
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(candidates[i]);
            dfs(candidates, target - candidates[i], lists, list1, i);
        }
    }

    /**
     * 回溯法
     *    private void backtrack(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> ans) {
     for (int i = start; i < candidates.length; i++) {
     int num = candidates[i];
     if (target < num) {
     break;
     }
     list.add(num);
     if (target == num) {
     ans.add(new ArrayList<>(list));
     list.remove(list.size() - 1);
     break;
     }
     backtrack(candidates, target - num, i, list, ans);
     list.remove(list.size() - 1);
     }
     }
     *
     *
     *
     */
}
