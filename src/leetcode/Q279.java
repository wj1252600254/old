package leetcode;

import java.util.Set;
import java.util.TreeSet;

public class Q279 {
    public int numSquares(int n) {
        Set<Integer> list = generate(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (list.contains(i)) {
                dp[i] = 1;
            }
            for (int j : list) {
                if (i + j > n) {
                    break;
                } else {
                    dp[i + j] = dp[i + j] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + j]);
                }

            }

        }
        return dp[n];

    }

    public Set<Integer> generate(int n) {
        Set<Integer> list = new TreeSet<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }
        return list;
    }
}
