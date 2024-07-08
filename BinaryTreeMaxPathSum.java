public class BinaryTreeMaxPathSum {
    public int help (TreeNode root, int[] ans) {
        if (root == null) return 0;

        int left = help (root.left, ans);
        int right = help (root.right, ans);

        int tempAns = Math.max(root.val, root.val + Math.max(right, left));
        int temp = Math.max(tempAns, root.val + left + right);
        ans[0] = Math.max(ans[0], temp);
        return tempAns;
    }
    public int maxPathSum(TreeNode root) {
        int[] ans = {Integer.MIN_VALUE};
        help (root, ans);
        return ans[0];
    }
}
