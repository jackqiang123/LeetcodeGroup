// Given a non-empty binary search tree and a target value,
// find the value in the BST that is closest to the target.
//
// Note:
//
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.
public class Solution{
  public int closestValue(TreeNode root, double target) {
    if (root == null) return -1;
    double rootSol = Math.abs(root.val - target);
    if (root.val < target){
      if (root.left != null){
        int leftindex = closest(root.left, target);
        double leftSol = Math.abs(leftindex - target);
        return rootSol < leftSol ? root.val : leftindex;
      }
      return root.val;
    }
    else {
      if (root.right != null){
        int rightindex = closest(root.right, target);
        double rightSol = Math.abs(rightindex - target);
        return rootSol < rightSol ? root.val : rightindex;
      }
      return root.val;
    }
  }
}
