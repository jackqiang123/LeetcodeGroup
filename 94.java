// Given a binary tree, return the inorder traversal of its nodes' values.
//
// For example:
// Given binary tree [1,null,2,3],
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].
//
// Note: Recursive solution is trivial, could you do it iteratively?

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // Use Morris Inorder traversal
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      while(root != null){
        if (root.left == null){
          res.add(root.val);
          root = root.right;
        }
        else {
          TreeNode left = root.left;
          TreeNode rightMost = findMax(root.left, root);
          if (rightMost.right == null){
            rightMost.right = root;
            root = left;
          }
          else {
            rightMost.right = null;
            res.add(root.val);
            root = root.right;
          }
        }
      }
      return res;
    }
    private TreeNode findMax(TreeNode root, TreeNode cycle){
      while (root.right != null && root.right != cycle) root = root.right;
      return root;
    }
}
