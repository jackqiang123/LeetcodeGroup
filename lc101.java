// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree is symmetric:
//
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
      if (root == null) return true;
      return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right){
      if (left == null || right == null) return left == right;
      return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left); 

    }
}
