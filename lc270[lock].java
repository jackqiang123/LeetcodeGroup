// Given a non-empty binary search tree and a target value,
// find the value in the BST that is closest to the target.
//
// Note:
//
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.
public class Solution{
  public int closestValue(TreeNode root, double target) {
    double rootSol = Math.abs(root.val - target);
    if (root.val < target){
      if (root.left != null){
        int leftValue = closestValue(root.left, target);
        double leftSol = Math.abs(leftValue - target);
        return rootSol < leftSol ? root.val : leftValue;
      }
      return root.val;
    }
    else {
      if (root.right != null){
        int rightValue= closestValue(root.right, target);
        double rightSol = Math.abs(rightValue - target);
        return rootSol < rightSol ? root.val : rightValue;
      }
      return root.val;
    }
  }
}
