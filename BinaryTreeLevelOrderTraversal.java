import java.util.*;
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();

                if (temp.left != null) q.add(temp.left);

                if (temp.right != null) q.add(temp.right);

                arr.add(temp.val);
            }
            ans.add(new ArrayList<>(arr));
        }
        return ans;
    }
}
