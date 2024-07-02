import java.util.*;
public class DecodeWays {
    public int help(String s, int ind, int prev, int[][] dp) {
        if (ind < 0) {
            if (prev == 27) return 1;
            return 0;
        }

        if (dp[ind][prev] != -1) return dp[ind][prev];

        char ch = s.charAt(ind);

        // 3 ways calls possible
        // consider ch to be a single decodation or consider ch to attach with the right character
        // or consider ch to attach with prev character

        if (prev == 27) { // if we didn't borrow any character from prev iteration
            int a = 0;
            if (ch != '0') a = help(s, ind - 1, 27, dp);
            int b = help (s, ind - 1, ch - '0', dp);

            return dp[ind][prev] = a + b;
        } else {
            if (ch == '0') return dp[ind][prev] = 0;
            if ((ch - '0' < 3) && !(ch == '2' && prev > 6)) {
                if (ind == 4) System.out.println("yes");
                return dp[ind][prev] = help(s, ind - 1, 27, dp);
            }
            return dp[ind][prev] = 0;
        }
    }

    public int numDecodings(String s) {
        int[][] dp = new int[s.length() + 1][28];
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return help(s, s.length() - 1, 27, dp);
    }
}
