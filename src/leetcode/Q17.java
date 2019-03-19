package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    private String[] strings=new String[]{" "," ","abc","def","ghi","jkl","mnl","opq","rst","uvw","xyz"};
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits==null||digits.length()==0){
            return list;
        }
        dfs(list,new StringBuilder(),digits);
        return list;
    }

    public void dfs(List<String> list,StringBuilder sb,String digits){
        if(sb.length()==digits.length()){
            list.add(sb.toString());
            return;
        }
        int number=digits.charAt(sb.length())-'0';
        String content=strings[number];
        for(char c:content.toCharArray()){
            sb.append(c);
            dfs(list,sb,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
