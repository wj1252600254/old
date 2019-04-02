package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q22 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("a");
        stringBuilder.setLength(0);
        stringBuilder.append("p");
        stringBuilder.setLength(1);
        String s = "";
        s += "A";
        s += "B";
        Q22 q22 = new Q22();
        System.out.println(q22.generateParenthesis(3));
    }

    /**
     * 递归方法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "";
        dfs(0, 0, n, s, list);
        return list;
    }


    public void dfs(int left, int right, int n, String s, List<String> list) {
        if (right ==  n) {
            list.add(s);
            return;
    }
        if (left < n) {
//            System.out.println(left + "---" + right+ s);
//            System.out.println("------------");

            s += "(";   //这种写法，是有错误的，在执行完一种情况，回到上一层dfs时，(  还是加上去了   也可以这么理解，s自身也变化了。与后面List的回溯类似的。
            //如果不想减掉，那么可以ｎｅｗ一个新的Ｓｔｒｉｎｇ，比如说Ｓｔｒｉｎｇ　ａ＝ｎｅｗ　Ｓｔｒｉｎｇ（ｓ＋＂（＂）
            dfs(left + 1, right, n, s , list);
            s=s.substring(0,s.length()-1);
        }

        if (right < left) {
//            System.out.println(left + "***" + right+ s);
//            System.out.println("*********");
            s += ")";
            dfs(left, right + 1, n, s , list);
            s=s.substring(0,s.length()-1);
        }


    }

    /**
     * 回溯法
     *
     * @param n
     * @return
     */
//    public List<String> generateParenthesis1(int n) {
//
//    }

}
