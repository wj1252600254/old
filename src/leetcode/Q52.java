package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q52 {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] row = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        dfs(new ArrayList<>(), row, diag1, diag2, 0, n);
        return count;
    }

    public void dfs(List<String> list, boolean[] row, boolean[] diag1, boolean[] diag2, int rowsize, int n) {
        if (rowsize == n) {
            count++;
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
            dfs(list, row, diag1, diag2, rowsize + 1, n);
            list.remove(list.size() - 1);
            chars[i] = '.';
            row[i] = false;
            diag1[rowsize + i] = false;
            diag2[rowsize + n - i - 1] = false;
        }
    }
}
