// Given a binary tree, determine if it is a valid binary search tree (BST).
//
// Assume a BST is defined as follows:
//
//    The left subtree of a node contains only nodes with keys less than the node's key.
//    The right subtree of a node contains only nodes with keys greater than the node's key.
//    Both the left and right subtrees must also be binary search trees.
//
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

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
    public boolean isValidBST(TreeNode root) {
      return isBST(root,null,null);
    }
    private boolean isBST(TreeNode root, Integer lower, Integer upper){
      if (root == null) return true;
      if (lower != null && root.val <= lower) return false;
      if (upper != null && root.val >= upper) return false;
      return isBST(root.left, lower, root.val) && isBST(root.right, root.val, upper);
    }
}
