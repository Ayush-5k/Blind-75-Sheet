public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int pre = 1,suf = 1,n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i < n; i++) {
            if(pre==0) pre=1;
            if(suf==0) suf=1;

            pre *= (int)nums[i];
            suf *= (int)nums[n-1-i];

            if (suf < (Integer.MAX_VALUE) / 2 || pre < (Integer.MAX_VALUE) / 2)
                ans = Math.max(ans, Math.max(pre, suf));
        }
        return ans;
    }
}
