package leetcode;

public class Q28 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    public int s(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0)
            return 0;
        int m = haystack.length();
        int n = needle.length();
        if (m < n) {
            return -1;
        } else if (m == n) {
            return haystack.equals(needle) ? 0 : -1;
        } else {
            for (int i = 0; i <= m - n; i++) {  //如果去<，则最后一个数娶不到
                if (haystack.substring(i, i + n).equals(needle))
                    return i;
            }
        }
        return -1;
    }
}
