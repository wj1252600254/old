//public class 正则表达式匹配 {
//    public boolean match(char[] str, char[] pattern) {
//        boolean[][] match = new boolean[str.length][pattern.length];
//        match[0][0] = true;
//        for (int i = 1; i < pattern.length; i++) {
//            if (pattern[i - 1] == '*') {
//                match[0][i] = match[0][i - 2];
//            }
//        }
//        for (int i = 1; i < str.length; i++) {
//            for (int j = 1; j < pattern.length; j++) {
//                if (str[i - 1] == pattern[j - 1] || pattern[i - 1] == '.') {
//                    match[i][j] = match[i - 1][j - 1];
//                } else if (pattern[j] == '*') {
//                    if (str[i - 1] == pattern[i - 2] || pattern[i - 2] == '.') {
//                        match[i][j] |= match[i][j - 2];
//                        match[i][j] |= match[i - 1][j];
//                        match[i][j] |= match[i][j - 2];
//                    } else {
//                        match[i][j] == match[i][j - 2];
//                    }
//                }
//            }
//        }
//        return match[str.length - 1][pattern.length - 1];
//    }
//}
