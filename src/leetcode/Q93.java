package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(list, sb, s, 0);
        return list;
    }
            /*
public List<String> restoreIpAddresses(String s) {
    List<String> addresses = new ArrayList<>();
    StringBuilder tempAddress = new StringBuilder();
    doRestore(0, tempAddress, addresses, s);
    return addresses;
}
*/


    /*

 private void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s) {
     if (k == 4 || s.length() == 0) {
         if (k == 4 && s.length() == 0) {
             addresses.add(tempAddress.toString());
         }
         return;
     }
     for (int i = 0; i < s.length() && i <= 2; i++) {
         if (i != 0 && s.charAt(0) == '0') {
             break;
         }
         String part = s.substring(0, i + 1);
         if (Integer.valueOf(part) <= 255) {
             if (tempAddress.length() != 0) {
                 part = "." + part;
             }
             tempAddress.append(part);
             doRestore(k + 1, tempAddress, addresses, s.substring(i + 1));
             tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
         }
     }
 }
  */
    public void dfs(List<String> list, StringBuilder sb, String s, int k) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                list.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i <= 2 && i < s.length(); i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }

            String c = s.substring(0, i + 1);
            if (Integer.valueOf(c) <= 255) {
                if (sb.length() != 0) {
                    c = "." + c;
                }
            }
            sb.append(c);
            dfs(list, sb, s.substring(i + 1), k + 1);
            sb.delete(sb.length() - c.length(), sb.length());    //此处代码应该放在if的循环语句里面

        }
    }
}

/*
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                list.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {    //i=0表示只有一个数，i=1表示有两个数，i=3表示有3个数。
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (sb.length() != 0) {
                    part = "." + part;
                }
            }
            sb.append(part);
            dfs(list, sb, s.substring(i + 1), k + 1);
            sb.delete(sb.length() - part.length(), sb.length());  //subString并没有改变字符串本身，delete是改变字符串本身。前开后闭
        }
    }
 */

