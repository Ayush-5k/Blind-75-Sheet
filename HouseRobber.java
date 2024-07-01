public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        boolean flag = false;
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][1] = Math.max(nums[i - 1] + dp[i - 1][0], dp[i - 1][1]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

        }
        return Math.max(dp[n][0], dp[n][1]);
    }
}
