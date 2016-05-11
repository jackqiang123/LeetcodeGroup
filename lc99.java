// Two elements of a binary search tree (BST) are swapped by mistake.
//
// Recover the tree without changing its structure.
// Note:
// A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
    TreeNode first;
    TreeNode second;
    TreeNode last;
    public void recoverTree(TreeNode root) {
      dfs(root);
      int t = first.val;
      first.val = second.val;
      second.val = t;
    }
    private void dfs(TreeNode root){
      if (root == null) return;
      dfs(root.left);
      if (last != null){
        if (root.val < last.val){
          if (first == null){
            first = last;
            second = root;
          }
          else {
            second = root;
          }
        }
      }
      last = root;
      dfs(root.right);
    }
}
