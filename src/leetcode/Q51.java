package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        boolean[] row = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        dfs(new ArrayList<>(), lists, row, diag1, diag2, 0, n);
        return lists;
    }

    public void dfs(List<String> list, List<List<String>> lists, boolean[] row, boolean[] diag1, boolean[] diag2, int rowsize, int n) {
        if (rowsize == n) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (row[i] || diag1[rowsize + i] || diag2[rowsize + n - 1 - i])
                continue;
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            String s = new String(chars);
            row[i] = true;
            diag1[rowsize + i] = true;
            diag2[rowsize - i + n - 1] = true;
            list.add(s);
            dfs(list, lists, row, diag1, diag2, rowsize + 1, n);
            list.remove(list.size() - 1);
            chars[i] = '.';
            row[i] = false;
            diag1[rowsize + i] = false;
            diag2[rowsize + n - i - 1] = false;
        }
    }
}
