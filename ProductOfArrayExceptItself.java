public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProd = new int[n];
        int[] rightProd = new int[n];
        int leftMul = 1;
        int rightMul = 1;
        for (int i = 0; i < n; i++) {
            leftProd[i] = leftMul;
            rightProd[n - i - 1] = rightMul;

            leftMul *= nums[i];
            rightMul *= nums[n - i - 1];
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = leftProd[i] * rightProd[i];
        }
        return ans;
    }
}
