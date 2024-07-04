public class ValidateBinarySearchTree {
    public boolean traverse(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val >= max || root.val <= min) return false;

        return traverse(root.left, min, root.val) && traverse(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
