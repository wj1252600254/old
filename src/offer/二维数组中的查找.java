package offer;

public class 二维数组中的查找 {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;
        int i = 0;
        int j = array[0].length-1;    //注意数组越界
        while (i < array.length && j >= 0) {
            if (target == array[i][j])
                return true;
            else if (array[i][j] > target) {
                j--;
            } else {    //if .. else if .. else
                i++;
            }
        }
        return false;
    }
}
