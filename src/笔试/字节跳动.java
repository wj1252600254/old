package 笔试;




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 字节跳动 {
    public static void main(String[] args) {
        char[] chars = new char[]{'w','o', 'o', 'o', 'o', 'o','o','w'};
        char[] chars1 = new char[]{'w','w', 'w', 'w', 'o', 'o','o','w'};
        char[] chars2 = new char[]{'w','w','w','o', 'o', 'o', 'w', 'w','w','0','0','0'};
//        System.out.println(judge(chars, 0));
        char[] temp = handle(judge(chars2, 0));
        System.out.println(new String(temp));
        System.out.println(handle(f(temp, 0)));



    }

    public void f1() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int diff = 1024 - a;
        int[] array = new int[]{64, 16, 4, 1};
        int count = 0;
        for (int i = 0; i <= 4; i++) {
            if (diff == 0) {
                System.out.println(count);
                return;
            }
            int a1 = diff / array[i];
            count += a1;
            diff = diff % array[i];
        }
    }

    /*----------------*/
    public void f2() {
        Scanner in = new Scanner(System.in);
        Integer number = Integer.valueOf(in.nextLine());
        List<String> list = new ArrayList<>();


        for (int i = 0; i < number; i++) {
            list.add(in.nextLine());
        }
        for (String t : list) {
            char[] temp = handle(judge(t.toCharArray(), 0));
            System.out.println(handle(f(temp, 0)));
        }
    }

    public static char[] judge(char[] s, int number) {
        if (s == null || s.length <= 2 ||s.length==number)
            return s;
        char a = s[number];
        if (a == s[++number]) {
            while (++number<s.length && a == s[number]) {
                s[number] = ' ';
            }
            judge(s, number);
        } else {
            judge(s, number);
        }
        return s;
    }

    public static char[] handle(char[] s) {
        int a = s.length;
        int count = 0;
        int c = 0;
        for (int i = 0; i < a; i++) {
            if (s[i] == ' ')
                count++;
        }
        char[] chars = new char[a - count];
        for (int i = 0; i < a; i++) {
            if (s[i] != ' ') {
                chars[c++] = s[i];
            }
        }
        return chars;
    }

    public static char[] f(char[] s, int number) {
        if (s == null || s.length <= 3 ||s.length-number<=3)
            return s;
        if ((number+3)<s.length&&s[number] == s[number + 1]) {
            if (s[number + 2] == s[number + 3]) {
                s[number + 3] = ' ';
            }
            f(s, number + 2);
        } else {
            f(s, number + 1);
        }
        return s;

    }









    /*----------------*/
}
