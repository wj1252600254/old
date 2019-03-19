package leetcode;

public class Q200 {
    public int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[0][0] != '0') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[0][0] == '0')
            return;
        grid[0][0] = '0';
        for (int[] temp : directions) {
            dfs(grid, x + temp[0], y + temp[1]);
        }
    }
}
