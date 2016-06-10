// Given a binary tree, count the number of uni-value subtrees.
//
// A Uni-value subtree means all nodes of the subtree have the same value.
//
// For example:
// Given binary tree,
//               5
//              / \
//             1   5
//            / \   \
//           5   5   5
// return 4.
public class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
      count = 0;
      helper(root);
      return count;
    }
    private boolean helper(TreeNode root){
        if (root == null) return true;
        if (root.left == null && root.right == null){
          count++; return true;
        }
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right && (root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)){
            count++;
            return true;
        }
        return false;
    }
  }
