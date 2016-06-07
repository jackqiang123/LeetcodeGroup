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
    private int sum;
    public int maxPathSum(TreeNode root) {
      sum = Integer.MIN_VALUE;
      int leftPathsum = partialSum(root.left);
      int rightPathsum = partialSum(root.right);
      return Math.max(sum, root.val + Math.max(leftPathsum, 0) + Math.max(rightPathsum, 0));
    }
    private int partialSum(TreeNode node){
      if(node == null) return 0;
      int left = Math.max(0, partialSum(node.left));
      int right = Math.max(0, partialSum(node.right));
      sum = Math.max(sum, node.val + left + right);
      return node.val + Math.max(left, right);
    }
}
