package leetcode;

public class Q79 {
    private int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        boolean[][] bools = new boolean[m][n];
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, bools, i, j, word,0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] bools, int r, int c, String word,int curlen) {
        if(curlen==word.length())
            return true;
        if (r < 0 || r >= m || c < 0 || c >= n || bools[r][c]||word.charAt(curlen)!=board[r][c]) {
            return false;
        }
        bools[r][c]=true;

        for(int[] t:direction){
            if(dfs(board,bools,r+t[0],c+t[1],word,curlen+1))
                return true;
        }
        bools[r][c]=false;
        return false;
    }
}
