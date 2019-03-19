package 笔试;

public class 七牛云 {
    public void f() {

    }

    public static void main(String[] args) {
        String a = "abcdefg";
        StringBuilder stringBuilder = new StringBuilder(a);
        String b = a.substring(0, 1);
        String c = a.substring(1);
        System.out.println(b);
        System.out.println(a);
        System.out.println(c);
        System.out.println(stringBuilder.delete(5, 7));
        String aaa = "255";
        System.out.println(Integer.valueOf(255));
    }
}
