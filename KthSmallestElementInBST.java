public class KthSmallestElementInBST {
    int count = 0;
    public void help (TreeNode root, int k, int[] ans) {
        if (root == null) return;
        help (root.left, k, ans);

        count++;
        if (count == k) {
            ans[0] = root.val;
            return;
        }

        help (root.right, k, ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1];
        help (root, k, ans);
        return ans[0];
    }
}
