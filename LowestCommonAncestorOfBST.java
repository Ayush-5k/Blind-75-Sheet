public class LowestCommonAncestorOfBST {
    public TreeNode help (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val == p.val) {
            return p;
        }
        if (root.val == q.val) {
            return q;
        }

        if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return help(root.left, p, q);
        } else {
            return help(root.right, p, q);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return help (root, p, q);
    }
}
