package Sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 1, 6, 7, 9, 8, 2, 4};
        dumpSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr) {
        sortq(arr, 0, arr.length - 1);
    }

    public static void sortq(int[] arr, int l, int h) {
        if (h <= l)
            return;
        int j = partition(arr, l, h);
        sortq(arr, l, j - 1);
        sortq(arr, j + 1, h);
    }

    public static int partition(int[] arr, int left, int right) {
        int i = left, j = right + 1;
        while (true) {
            while (arr[left] > arr[++i] && i != right) ;   //从左往右
            while (arr[left] < arr[--j] && j != left) ;
            if (i >= j) {   //这边必须是i>=j
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, left, j);
        return j;
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, temp, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int[] temp, int l, int h) {
        if (l >= h)
            return;
        int medium = l + (h - l) / 2;
        sort(arr, temp, l, medium);
        sort(arr, temp, medium + 1, h);
        merge(arr, temp, l, medium, h);

    }

    public static void merge(int[] arr, int[] temp, int left, int m, int right) {
        int i = left, j = m + 1;
        for (int p = left; p <= right; p++) {
            temp[p] = arr[p];
        }
        for (int k = left; k <= right; k++) {
            if (i > m) {
                arr[k] = temp[j++];
            } else if (j > right) {
                arr[k] = temp[i++];
            } else if (arr[i] < arr[j]) {
                arr[k] = temp[i++];
            } else {
                arr[k] = temp[j++];
            }
        }
    }


    /**
     * 堆排序，大顶堆，升序
     */
    public static void dumpSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {   //i>0而不是i>=0
            swap(arr, 0, i);
            adjust(arr, 0, i);
        }
    }


    /**
     * 调整堆节点,sink
     * 子节点位置和父节点的位置关系，假设父节点在i，则左为2*i+1,右为2*i+2
     */
    public static void adjust(int[] arr, int k, int len) {
        int temp = arr[k];
        for (int i = 2 * k + 1; i < len; i = i * 2 + 1) {
            if (i + 1 < len && arr[i] < arr[i + 1]) {
                i++;
            }
            if (arr[i] > temp) {
                arr[k] = arr[i];
                k = i;
            } else
                break;
            arr[i] = temp;
        }
    }


    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void ShareSort(int[] arr) {
        int h = 1;
        int len = arr.length;
        if (len / 3 > h) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        swap(arr, j, j - h);
                    }
                }
            }
            h = h / 3;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 选择排序
     */
    public static void select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubble(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length && !flag; i++) {
            flag = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    flag = false;
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insert(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }
}
