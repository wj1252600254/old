package offer;

public class 矩阵中的路径 {
    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
     * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
     * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    private int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int rows;
    private int cols;


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.cols = cols;
        this.rows = rows;
        boolean flag = false;
        if (matrix.length != rows * cols)
            return false;
        char[][] arr = change(matrix, rows, cols);
        boolean[][] bools = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(backTracing(arr,bools,i,j,0,str))   //此处很关键额
                    return true;
            }
        }
        return false;
    }

    public boolean backTracing(char[][] arr, boolean[][] flag, int r, int c, int len, char[] str) {
        if (len == str.length)
            return true;
        if (r < 0 || r >= rows || c < 0 || c >= cols || flag[r][c] || str[len] != arr[r][c])
            return false;
        flag[r][c]=true;
        for(int[] temp:move){
            if(backTracing(arr,flag,r+temp[0],c+temp[1],len+1,str))  //此处很关键呢
                return true;
        }
        flag[r][c]=false;
        return false;
    }

    public char[][] change(char[] arr, int rows, int cols) {
        char[][] arrs = new char[rows][cols];
        for (int i = 0, p = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arrs[i][j] = arr[p++];
            }
        }

        return arrs;
    }
}
