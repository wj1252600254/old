package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 拼多多403 {
    public static void main(String[] args) {
        String a = "31, 18, 19, 1, 25";
        String[] strings = a.split(",");
        for (String s : strings) {
            System.out.println(Integer.parseInt(s.trim()));
        }
    }

    public void f1() {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int len = Integer.parseInt(a);
        String[] strings = b.split(" ");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(arr);
        int[] handle = new int[len / 2];
        for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
            handle[i] = arr[i] + arr[j];
        }
        Arrays.sort(handle);
        System.out.println(handle[len / 2 - 1] - handle[0]);
    }

    public void f2() {
        Scanner in = new Scanner(System.in);
        String sa = in.nextLine();
        String sb = in.nextLine();
        String sc = in.nextLine();
        String[] strings = sa.split(" ");
        System.out.println(Arrays.toString(strings));
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        int b = Integer.valueOf(sb);
        int c = Integer.valueOf(sc);
        String s1 = "";
        String s2 = "";
        boolean flag = true;
        if (b < arr[0] || c < arr[0]) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (b == 0 && c == 0)
                break;
            while (flag) {
                if (b > 0 && arr[i] > 0) {
                    s1 += i;
                    b--;
                    arr[i] -= 1;
                } else if (b != 0 && arr[i] == 0) {
                    break;
                } else {
                    flag = false;
                }
            }
            while (!flag) {
                if (c > 0 && arr[i] > 0) {
                    s2 += i;
                    c--;
                    arr[i] -= 1;
                } else if (arr[i] == 0) {
                    break;
                }
            }
        }
        System.out.println(Long.parseLong(s1) * Long.parseLong(s2));
    }

    public void f3() {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        s1 = s1.substring(1, s1.length() - 1);
        String[] strings = s1.split(",");
        int len = strings.length;
        String s2 = in.nextLine();
        int diff = Integer.parseInt(s2);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.valueOf(strings[i]);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int total = len * (len - 1) / 2;
        double cnt = 0.0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[j] - arr[i] <= diff) {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(diff);
        System.out.println(total);
        String ans = String.valueOf(cnt / total);
        String res = "";
        if (ans.length() > 8) {
            res = ans.substring(0, 7);
            if (ans.charAt(8) - '0' > 5) {
                res += (ans.charAt(7) - '0' + 1);
            } else {
                res += ans.charAt(7);
            }
        } else {
            res = ans;
            while (res.length() < 8) {
                res += "0";
            }
        }
        System.out.println(res);
    }

    public void f4() {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        if (a.endsWith(b)) {
            System.out.println(0);
            return;
        }
    }
}
