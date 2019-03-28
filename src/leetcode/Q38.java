package leetcode;

public class Q38 {
    /**
     * 1
     * 11
     * 21
     * 1211
     * 111221
     * 312211
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String a = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char[] chars = a.toCharArray();
            char c = chars[0];
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != c) {
                    sb.append(count);
                    sb.append(c);
                    c = chars[j];
                    count = 1;
                } else {
                    count++;
                }
            }
            if (count != 0) {
                sb.append(count);
                sb.append(c);
            }

            if (i == n) {
                return sb.toString();
            }
            a = sb.toString();

        }
        return null;
    }
}
