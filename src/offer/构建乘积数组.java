package offer;

public class 构建乘积数组 {
    public static void main(String[] args) {
        for (int i = 1, p = 1; i < 10; p *= i, i++) {
            System.out.println(p);
        }
    }

    public int[] multiply(int[] A) {
        int[] ans = new int[A.length];
        for (int i = 0, p = 1; i < A.length; p *= A[i], i++) {
            ans[i] = p;
        }
        for (int i = A.length - 1, p = 1; i >= 0; p *= A[i], i--) {
            ans[i] *= p;
        }
        return ans;
    }
}
