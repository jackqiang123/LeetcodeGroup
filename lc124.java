// Given a binary tree, find the maximum path sum.
//
// For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
// The path does not need to go through the root.
//
// For example:
// Given the below binary tree,
//
//       1
//      / \
//     2   3
//
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
    public int maxPathSum(TreeNode root) {
      int leftPathsum = depth(root.left)
      int rightPathsum = depth(root.right);
      return 1 + Math.max(leftPathsum, 0) + Math.max(rightPathsum, 0);
    }
    private int depth(TreeNode node){
      
    }
}
