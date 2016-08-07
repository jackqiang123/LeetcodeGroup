// Given a binary tree, find the maximum path sum.
//
// For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.
//
// For example:
// Given the below binary tree,
//
//        1
//       / \
//      2   3
// Return 6.
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
    int max;
    public int maxPathSum(TreeNode root) {
      max = Integer.MIN_VALUE;
      helper(root);
      return max;
    }
    private int helper(TreeNode root){
      if (root == null) return 0;
      int leftDepth = Math.max(0, helper(root.left));
      int rightDepth = Math.max(0, helper(root.right));
      max = Math.max(max, root.val + leftDepth + rightDepth);
      return root.val + Math.max(leftDepth, rightDepth);
    }
}
