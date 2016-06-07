// Given preorder and inorder traversal of a tree, construct the binary tree.
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
    Map<Integer,Integer> valueToIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      valueToIndex = new HashMap();
      for (int i = 0; i < inorder.length; i++){
        valueToIndex.put(inorder[i],i);
      }
      return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int []pre, int rootindex, int []ind, int start, int end){
      if (end < start) return null;
      if (end == start) return new TreeNode(ind[start]);
      TreeNode root = new TreeNode(pre[rootindex]);
      int mid = valueToIndex.get(pre[rootindex]);
      root.left = helper(pre, rootindex + 1, ind, start, mid - 1);
      int leftlen = mid - start;
      root.right = helper(pre, rootindex + 1 + leftlen, ind, mid + 1, end);
      return root;
    }
}
