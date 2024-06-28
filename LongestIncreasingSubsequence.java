import java.util.*;
public class LongestIncreasingSubsequence {
    public int help(int ind, int[] nums, int prevIndex, int[][] dp) {
        if (ind == nums.length) {
            return 0;
        }

        if (dp[ind][prevIndex + 1] != -1) {
            return dp[ind][prevIndex + 1];
        }

        int include = 0;
        if (prevIndex == -1 || nums[ind] > nums[prevIndex]) {
            include = 1 + help(ind + 1, nums, ind, dp);
        }
        int exclude = help(ind + 1, nums, prevIndex, dp);

        dp[ind][prevIndex + 1] = Math.max(include, exclude);
        return dp[ind][prevIndex + 1];
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return help(0, nums, -1, dp);
    }
}
