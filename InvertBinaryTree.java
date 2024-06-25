public class InvertBinaryTree {
    private TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null){
            left = invert(root.left);
        }
        if (root.right != null) {
            right = invert(root.right);
        }
        root.left = right;
        root.right = left;
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        return invert (root);
    }
}
