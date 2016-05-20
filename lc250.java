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
    public int countUnivalSubtrees(TreeNode root) {
      if (root == 0) return 0;
      if (root.left == null && root.right == null) return 1;
      int leftSubTree = countUnivalSubtrees(root.left);
      int rightSubTree = countUnivalSubtrees(root.right);
      if (leftSubTree == 0 && rightSubTree == 0)
        return 1;
      else if (leftSubTree != 0 && rightSubTree != 0){
        if (root.left.val == root.right.val && root.left.val == root.val)
          return leftSubTree + rightSubTree + 1;
        else return leftSubTree + rightSubTree;
      }
      else if (leftSubTree == 0){
        if (root.val == root.right.val)
          return rightSubTree + 1;
        return rightSubTree;
      }
      else
      {
        if (root.val == root.left.val)
          return leftSubTree + 1;
        return leftSubTree;
      }
    }
  }
