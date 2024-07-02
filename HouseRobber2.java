public class HouseRobber2 {
    public int help (int[] nums, int start, int end) {
        int n = end;
        int[][] dp = new int[n + 1][2];
        boolean flag = false;
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = start + 1; i <= n; i++) {
            dp[i][1] = Math.max(nums[i - 1] + dp[i - 1][0], dp[i - 1][1]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

        }
        return Math.max(dp[n][0], dp[n][1]);
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(help(nums, 0, nums.length - 1), help(nums, 1, nums.length));
    }
}
