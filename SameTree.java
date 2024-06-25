public class SameTree {
    public boolean find (TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            }
            return false;
        }

        if (p.val == q.val) {
            return find(p.left, q.left) && find (p.right, q.right);
        }
        return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return find(p, q);
    }
}
