package leetcode;

public class Q37 {
    /**
     * 回溯算法
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    block[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board, rows, cols, block, 0, 0);
    }


    public boolean dfs(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] block, int i, int j) {
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9)
                return true;
        }
        for (int num = 1; num <= 9; num++) {
            int index = i / 3 * 3 + j / 3;
            if (!rows[i][num] && !cols[j][num] && !block[index][num]) {
                board[i][j] = (char) ('0' + num);
                rows[i][num] = true;
                cols[j][num] = true;
                block[index][num] = true;
                if (dfs(board, rows, cols, block, i, j)) {
                    return true;
                } else {
                    board[i][j] = '.';
                    rows[i][num] = false;
                    cols[j][num] = false;
                    block[index][num] = false;
                }
            }
        }
        return false;
    }
}
