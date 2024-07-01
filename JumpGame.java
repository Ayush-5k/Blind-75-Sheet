public class JumpGame {
    Boolean[] dp;

    public boolean help(int ind, int[] nums) {
        if (ind == nums.length - 1) return true;
        if (ind >= nums.length) return false;

        if (dp[ind] != null) return dp[ind];

        for (int i = ind + 1; i <= ind + nums[ind] && i < nums.length; i++) {
            if (help(i, nums)) return dp[ind] = true;
        }
        return dp[ind] = false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new Boolean[n];
        return help(0, nums);
    }
}
