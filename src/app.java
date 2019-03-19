import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String s3 = in.nextLine();
        int a = Integer.valueOf(s1);
        int[] arr1 = new int[a];
        int[] arr2 = new int[a];
        String[] strings2 = s2.split(" ");
        String[] strings3 = s3.split(" ");
        for (int i = 0; i < a; i++) {
            arr1[i] = Integer.valueOf(strings2[i]);
            arr2[i] = Integer.valueOf(strings3[i]);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = a - 1;
        int sum = 0;
        while (i < a && j >= 0) {
            sum += arr1[i++] * arr2[j--];
        }
        System.out.println(sum);
    }

    public void f() {
        Map<Character, Integer> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        if (s1.length() == 1) {
            System.out.println(s1.toLowerCase());
            return;
        }
        String s2 = s1.toLowerCase();
        char[] chars = s2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                int t = map.get(chars[i]);
                if (chars[t] <= chars[t + 1]) {
                    chars[t + 1] = '0';
                    continue;
                } else {
                    chars[t] = '0';
                }
            }
            map.put(chars[i], i);
        }
        int count = 0;
        while (count < chars.length) {
            if (chars[count] != '0') {
                System.out.println(chars[count]);
                return;
            }
            count++;
        }
    }


    public void f1() {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String[] strings = s1.split(" ");
        int a = Integer.valueOf(strings[0]);
        int b = Integer.valueOf(strings[1]);
        int[][] arrs = new int[a][2];
        for (int i = 0; i < a; i++) {
            String s = in.nextLine();
            String[] strings1 = s.split(" ");
            int a1 = Integer.valueOf(strings1[0]);
            int b1 = Integer.valueOf(strings1[1]);
            arrs[i][0] = a1;
            arrs[i][1] = b1;
        }
        int[] dp = new int[a + 1];
        int c = 0;
        for (int i = 1; i <= b; i++) {
            if (i >= arrs[0][0]) {
                dp[i] = arrs[0][1];
            } else {
                dp[i] = 0;
            }
        }
        for (int[] temp : arrs) {
            for (int j = b + 1; j <= arrs[a - 1][0]; j++) {
                if (j > b) {
                    c = dp[j - b] + temp[1];
                }
                dp[j] = Math.max(dp[j], c);
            }
        }
        System.out.println(dp[a]);
        System.out.println(Arrays.toString(dp));
        System.out.println(arrs[0][0]);


    }
}
