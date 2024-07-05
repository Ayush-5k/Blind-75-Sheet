import java.util.*;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int preorderIndex = 0;
    public TreeNode help(int[] preorder, int[] inorder, HashMap<Integer, Integer> inorderMap, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        root.left = help(preorder, inorder, inorderMap, left, inorderMap.get(rootVal) - 1);
        root.right = help(preorder, inorder, inorderMap, inorderMap.get(rootVal) + 1, right);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return help(preorder, inorder, map, 0, inorder.length - 1);
    }
}
