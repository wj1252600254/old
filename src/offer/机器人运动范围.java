package offer;

public class 机器人运动范围 {
    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    private int rows;
    private int cols;
    private int count;
    private int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0)
            return 0;
        this.rows = rows;
        this.cols = cols;
        int[][] arr = new int[rows][cols];
        boolean[][] bools = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = count(i) + count(j);
            }
        }
        dfs(arr, bools, 0, 0, threshold);
        return count;
    }

    public void dfs(int[][] arr, boolean[][] bools, int r, int c, int th) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || bools[r][c] || arr[r][c] > th)
            return;
            count++;
        bools[r][c] = true;
        for (int[] temp : move) {
            dfs(arr, bools, r + temp[0], c + temp[1], th);
        }
    }

    public int count(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        机器人运动范围 s = new 机器人运动范围();
        System.out.println(s.count(189));
    }

}
