package leetcode;

public class Q64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0]=grid[0][0];
        for (int i = 1; i < row; i++) {
            for (int j = 1; i < col; j++) {
                if(i==0)
                    dp[i][j]=dp[i][j-1];
                else if(j==0)
                    dp[i][j]=dp[i-1][j];
            }
        }
        return 2;
    }
}
