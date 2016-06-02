// Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
// where largest means subtree with largest number of nodes in it.
//
// Note:
// A subtree must include all of its descendants.
// Here's an example:
//
//     10
//     / \
//    5  15
//   / \   \
//  1   8   7
// The Largest BST Subtree in this case is the highlighted one.
// The return value is the subtree's size, which is 3.
//
//
//
// Hint:
//
// You can recursively use algorithm similar to 98.
// Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
// Follow up:
// Can you figure out ways to solve it with O(n) time complexity?
public class Solution{
    int max;
    class Result{
      boolean isBST;
      int size;
      int lower;
      int upper;
      public Result(boolean isBST, int size, Integer lower, Integer upper){
        this.isBST = isBST;
        this.size = size;
        this.lower = lower;
        this.upper = upper;
      }
    }
    public int largestBSTSubtree(TreeNode root) {
      max = 0;
      isValid(root);
      return max;
    }
      // return the size of BST if valid, return -1 is not a BST
    private Result isValid(TreeNode root, int lower, int upper){
      if (root == null) return new Result(true, 0, null, null);
      Result leftResult = isValid(root.left);
      Result rightResult = isValid(root.right);
      if (leftResult.isBST && rightResult.isBST){
          if ((leftResult.upper == null || leftResult.upper < root.val) &&  (rightResult.lower == null || rightResult.lower > root.val))
          {
              max = Math.max(max, leftResult.size + rightResult + 1);
              return new Result(true, leftResult.size + rightResult + 1, leftResult.lower == null ? root.val : leftResult.lower, rightResult.upper == null ? root.val : rightResult.upper);
          }
      }
      return new Result(false, -1, null, null);
    }
}
