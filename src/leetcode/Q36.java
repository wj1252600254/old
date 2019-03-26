package leetcode;

import java.util.HashMap;

public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] nums = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            nums[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = (int) board[i][j];
                    int index = (i / 3) * 3 + j / 3;
                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    cols[j].put(num, cols[j].getOrDefault(num, 0) + 1);
                    nums[index].put(num, nums[index].getOrDefault(num, 0) + 1);
                    if (rows[i].get(num) > 1 || cols[j].get(num) > 1 || nums[index].get(num) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
