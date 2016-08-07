// Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      for (int i = 0; i < inorder.length; i++)
        map.put(inorder[i], i); // value to index
      return builder(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }
    private TreeNode builder(int []inorder, int start, int end, int[]postorder, int rootindex){
      if (start > end) return null;
      int rootValue = postorder[rootindex];
      int rootPos = map.get(rootValue);
      int leftLen = rootPos - start;
      int rightLen = end - rootPos;
      TreeNode root = new TreeNode(rootValue);
      root.left = builder(inorder, start, rootPos - 1, postorder, rootindex - rightLen - 1);
      root.right = builder(inorder, rootPos + 1, end, postorder, rootindex - 1);
      return root;
    }
}
