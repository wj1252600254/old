package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, lists, new ArrayList<>());
        return lists;
    }

    public void dfs(int[] candidates, int target, int num, List<List<Integer>> lists, List<Integer> list) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (target < 0)
            return;
        for (int i = num; i < candidates.length; i++) {
            if(i>num&&candidates[i]==candidates[i-1])
                continue;
            list.add(list.size(),candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, lists, list);
            list.remove(list.size() - 1);
        }
    }
}
