// Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.
//
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
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

    public List<TreeNode> generateTrees(int n) {
      return helper(1,n);
    }
    private List<TreeNode> helper(int start, int end){
      List<TreeNode> res = new ArrayList<TreeNode>();
      if (end < start) return res;
      for (int mid = start; mid <= end; mid++){
        List<TreeNode> left = helper(start, mid - 1);
        if(left.size() == 0) left.add(null);
        List<TreeNode> right = helper(mid + 1, end);
        if (right.size() == 0) right.add(null);
        for (TreeNode leftroot : left){
          for (TreeNode rightroot : right){
            TreeNode root = new TreeNode(mid);
            root.left = leftroot;
            root.right = rightroot;
            res.add(root);
          }
        }
      }
      return res;
    }

}
