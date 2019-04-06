package offer;

public class 调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int[] array) {
        int count = 0;
        for (int t : array) {
            if (t % 2 == 1)
                count++;
        }
        int[] arr = array.clone();
        int i = 0, j = count;
        for (int t : arr) {
            if (t % 2 == 1) {
                array[i++] = t;
            } else {
                array[j++] = t;
            }
        }
    }
}
